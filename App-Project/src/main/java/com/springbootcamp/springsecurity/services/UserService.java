package com.springbootcamp.springsecurity.services;

import com.springbootcamp.springsecurity.Exception.AccountDoesNotExist;
import com.springbootcamp.springsecurity.Exception.InvalidDetails;
import com.springbootcamp.springsecurity.domain.token.ForgotPasswordToken;
import com.springbootcamp.springsecurity.domain.user.Users;
import com.springbootcamp.springsecurity.dto.ForgotPasswordDto;
import com.springbootcamp.springsecurity.repository.ForgotPasswordTokenRepository;
import com.springbootcamp.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MessageSource messages;
    @Autowired
    JavaMailSender mailSender;
    @Autowired
    ForgotPasswordTokenRepository forgotPasswordTokenRepository;

    public String changeActivationStatusOfUser(Long id){
        Users user= userRepository.findById(id).get();
        if (user.getActive() == true){
            user.setActive(false);
        }
        else {
            user.setActive(true);
        }
        userRepository.save(user);
        return "Activation Status Is Changed";
    }
    public String changeRoleOfUser(Long id,String role){
        Users user= userRepository.findById(id).get();
        user.getRoleList().get(0).setAuthority(role);
        userRepository.save(user);
        return "User Role Is Changed";
    }

    //this function will generate a link to change password
    public String forgotPasswordToken(String email, WebRequest request){

        if(!isValidEmail(email)) {
            return "invalid email";
        }
        Users user = userRepository.findByEmail(email);
        String message;
        if(user==null)
            throw new AccountDoesNotExist("Invalid Email Address");

        else if(!user.getActive())
            message = "user is de-activated";

            // user is activated - eligible fot this operation.
        else{
            //Token to reset password
            String token = UUID.randomUUID().toString();
            createForgotPasswordToken(token, user);

            //Email message content
            String recipientAddress = user.getEmail();
            String subject = "Forgot Password";
            String confirmationUrl = "/reset-password?token=" + token;
            String emailMessage = "please click on this link to reset your password";

            System.out.println(confirmationUrl);

            //Set content in mail
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(recipientAddress);
            mail.setSubject(subject);
            String newUrl = "http://localhost:8080" + confirmationUrl ;
            mail.setText(emailMessage + "\r\n" + newUrl);
            System.out.println(newUrl);

            mailSender.send(mail);

            message = messages.getMessage("message.resendToken", null, request.getLocale()); //Problem Message is not set
        }
        return "Soon you will get a password reset link on register email";
    }

    //Function to store token , used to reset password
    public void createForgotPasswordToken(String token, Users user){
        ForgotPasswordToken forgotPasswordToken = new ForgotPasswordToken(token, user);
        //forgotPasswordRepository.save(forgotPasswordToken);
        forgotPasswordTokenRepository.save(forgotPasswordToken);
    }
    public ForgotPasswordToken getForgotPasswordToken(String token){
        return forgotPasswordTokenRepository.findByToken(token);
    }

    public String resetPassword(String token, ForgotPasswordDto forgotPasswordDto,WebRequest webRequest) {
        Locale locale = webRequest.getLocale();
        ForgotPasswordToken forgotPasswordToken = getForgotPasswordToken(token);

        if (forgotPasswordToken == null){
            return "Token is Invalid";
        }
        Users user = forgotPasswordToken.getUser();
        Calendar calendar = Calendar.getInstance();
        if (forgotPasswordToken.getExpiryDate().getTime() -calendar.getTime().getTime() <=0){
            forgotPasswordTokenRepository.delete(forgotPasswordToken);
            return "Token Validity is Expired";
        }
        user.setPassword(forgotPasswordDto.getPassword());
        userRepository.save(user);
        forgotPasswordTokenRepository.delete(forgotPasswordToken);
        return "Password Is Changed Successfully";
    }

    public boolean passwordMatches(String str1, String str2){
        if (!str1.equals(str2)){
            throw new InvalidDetails("Password And Confirm Password Are No Same");
        }
        return true;
    }
    public boolean isValidEmail(String email){
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";
        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
