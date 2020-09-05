package com.aquoco.starthere.models;

import com.aquoco.starthere.logging.Loggable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

// User is considered the parent entity

@Loggable
@Entity
@Table(name = "customers")
public class Customer extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customersid;

    @Column(nullable = false,
            unique = true)
    private String username;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(nullable = false,
            unique = true)
    @Email
    private String email;


    public Customer() {
    }

    public Customer(String username,
                String password,
                String email) {
        setUsername(username);
        setPassword(password);
        this.email = email;
    }

    public long getCustomersid() {
        return customersid;
    }

    public void setCustomersid(long customersid) {
        this.customersid = customersid;
    }

    public String getUsername() {
        if (username == null) // this is possible when updating a user
        {
            return null;
        } else {
            return username.toLowerCase();
        }
    }

    public void setUsername(String username) {
        this.username = username.toLowerCase();
    }

    public String getPrimaryemail() {
        if (email == null) // this is possible when updating a user
        {
            return null;
        } else {
            return email.toLowerCase();
        }
    }

    public void setPrimaryemail(String email) {
        this.email = email.toLowerCase();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

    public void setPasswordNoEncrypt(String password) {
        this.password = password;
    }

    @JsonIgnore
    public List<SimpleGrantedAuthority> getAuthority() {
        List<SimpleGrantedAuthority> rtnList = new ArrayList<>();
/*
        for (UserType r : this.usertypes) {
            String myRole = "ROLE_" + r.getUsername()
                                       .toUpperCase();
            rtnList.add(new SimpleGrantedAuthority(myRole));
        }
*/
        return rtnList;
    }

    @Override
    public String toString() {
        return "User{" + "customersid=" + customersid + ", username='" + username + '\'' + ", password='" + password + '\'' + ", email='" + email + '\'' + '}';
    }
}
