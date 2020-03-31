package com.springbootcamp.springsecurity.domain.user;

import com.springbootcamp.springsecurity.domain.Role;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "APP_USERS")
@Inheritance(strategy = InheritanceType.JOINED)
public class AppUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String EMAIL;
    private String FIRST_Name;
    private String MIDDLE_Name;
    private String LAST_Name;
    private String PASSWORD;
    private Boolean IS_DELETED;
    private Boolean IS_ACTIVE;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE",joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID",referencedColumnName = "ID"))
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @OneToMany(mappedBy = "appUser",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Addresses> addressesList;

    public List<Addresses> getAddressesList() {
        return addressesList;
    }

    public void setAddressesList(List<Addresses> addressesList) {
        this.addressesList = addressesList;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getFIRST_Name() {
        return FIRST_Name;
    }

    public void setFIRST_Name(String FIRST_Name) {
        this.FIRST_Name = FIRST_Name;
    }

    public String getMIDDLE_Name() {
        return MIDDLE_Name;
    }

    public void setMIDDLE_Name(String MIDDLE_Name) {
        this.MIDDLE_Name = MIDDLE_Name;
    }

    public String getLAST_Name() {
        return LAST_Name;
    }

    public void setLAST_Name(String LAST_Name) {
        this.LAST_Name = LAST_Name;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public Boolean getIS_DELETED() {
        return IS_DELETED;
    }

    public void setIS_DELETED(Boolean IS_DELETED) {
        this.IS_DELETED = IS_DELETED;
    }

    public Boolean getIS_ACTIVE() {
        return IS_ACTIVE;
    }

    public void setIS_ACTIVE(Boolean IS_ACTIVE) {
        this.IS_ACTIVE = IS_ACTIVE;
    }

    @Override
    public String toString() {
        return "AppUsers{" +
                "ID=" + ID +
                ", EMAIL='" + EMAIL + '\'' +
                ", FIRST_Name='" + FIRST_Name + '\'' +
                ", MIDDLE_Name='" + MIDDLE_Name + '\'' +
                ", LAST_Name='" + LAST_Name + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", IS_DELETED=" + IS_DELETED +
                ", IS_ACTIVE=" + IS_ACTIVE +
                ", roleList=" + roleList +
                ", addressesList=" + addressesList +
                '}';
    }
}
