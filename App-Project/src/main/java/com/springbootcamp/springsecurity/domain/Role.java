package com.springbootcamp.springsecurity.domain;
import com.springbootcamp.springsecurity.domain.user.Users;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ROLE")
public class Role {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String authority;


    @ManyToMany(mappedBy = "roleList",fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Users> UsersList;
//    @Fetch(value = FetchMode.SUBSELECT)

    public List<Users> getUsersList() {
        return UsersList;
    }

    public void setUsersList(List<Users> appUsersList) {
        this.UsersList = UsersList;
    }

    public  Role(){

    }

    public Role(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                ", appUsersList=" + UsersList +
                '}';
    }
}
