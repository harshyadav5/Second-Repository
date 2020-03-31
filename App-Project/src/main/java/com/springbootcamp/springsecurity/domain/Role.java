package com.springbootcamp.springsecurity.domain;

import com.springbootcamp.springsecurity.domain.user.AppUsers;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ROLE")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String AUTHORITY;


    @ManyToMany(mappedBy = "roleList",fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<AppUsers> appUsersList;

    public List<AppUsers> getAppUsersList() {
        return appUsersList;
    }

    public void setAppUsersList(List<AppUsers> appUsersList) {
        this.appUsersList = appUsersList;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getAUTHORITY() {
        return AUTHORITY;
    }

    public void setAUTHORITY(String AUTHORITY) {
        this.AUTHORITY = AUTHORITY;
    }

    @Override
    public String toString() {
        return "Role{" +
                "ID=" + ID +
                ", AUTHORITY='" + AUTHORITY + '\'' +
                '}';
    }
}
