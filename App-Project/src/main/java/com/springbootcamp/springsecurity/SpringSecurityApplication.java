package com.springbootcamp.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@RestController
@SpringBootApplication
public class SpringSecurityApplication {
	@Bean
	public LocaleResolver localeResolver(){
		AcceptHeaderLocaleResolver locale_resolver = new AcceptHeaderLocaleResolver();
		locale_resolver.setDefaultLocale(Locale.US);
		return locale_resolver;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

}
