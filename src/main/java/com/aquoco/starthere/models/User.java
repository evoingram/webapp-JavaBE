package com.aquoco.starthere.models;

import com.aquoco.starthere.logging.Loggable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

// User is considered the parent entity

@Loggable
@Entity
@Table(name = "users")
public class User
        extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    @Column(nullable = false,
            unique = true)
    private String username;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(nullable = false,
            unique = true)
    @Email
    private String primaryemail;

    @Column(nullable = false)
    private boolean factoring = false;

    @Column
    private String company;

    @Column
    private String mrms;

    @Column(nullable = false)
    @Size(min=3, max=240)
    private String lastname;

    @Column(nullable = false)
    @Size(min=3, max=240)
    private String firstname;

    @Column
    private String jobtitle;

    @Column
    @Pattern(regexp="\\(\\d{3}\\) \\d{3}-\\d{4}")
    private String businessphone;

    @Column(nullable = false)
    private String address1;

    @Column
    private String address2;

    @Column(nullable = false)
    @Size(min=2, max=240)
    private String city;

    @Column(nullable = false)
    @Size(min=2, max=2)
    private String state;

    @Column(nullable = false)
    @Size(min=5, max=5)
    private String postalcode;

    @Column
    private String notes;


    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private List<UserRoles> userroles = new ArrayList<>();

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("user")
    private List<Useremail> useremails = new ArrayList<>();

    public User() {
    }

    public User(String username,
                String password,
                String primaryemail,
                boolean factoring,
                String company,
                String mrms,
                String lastname,
                String firstname,
                String jobtitle,
                String businessphone,
                String address1,
                String address2,
                String city,
                String state,
                String postalcode,
                String notes,
                List<UserRoles> userRoles) {
        setUsername(username);
        setPassword(password);
        this.primaryemail = primaryemail;
        this.factoring = factoring;
        this.company = company;
        this.mrms = mrms;
        this.lastname = lastname;
        this.firstname = firstname;
        this.jobtitle = jobtitle;
        this.businessphone = businessphone;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.postalcode = postalcode;
        this.notes = notes;
        for (UserRoles ur : userRoles) {
            ur.setUser(this);
        }
        this.userroles = userRoles;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
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
        if (primaryemail == null) // this is possible when updating a user
        {
            return null;
        } else {
            return primaryemail.toLowerCase();
        }
    }

    public void setPrimaryemail(String primaryemail) {
        this.primaryemail = primaryemail.toLowerCase();
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

    public boolean isFactoring() {
        return factoring;
    }

    public void setFactoring(boolean factoring) {

            this.factoring = factoring;
    }

    public String getCompany() {
        if (company == null)
        {
            return null;
        } else {
            return company;
        }
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMrms() {
        if (mrms == null)
        {
            return null;
        } else {
            return mrms;
        }
    }

    public void setMrms(String mrms) {
        this.mrms = mrms;
    }

    public String getLastname() {
        if (lastname == null)
        {
            return null;
        } else {
            return lastname;
        }
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        if (firstname == null)
        {
            return null;
        } else {
            return firstname;
        }
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getJobtitle() {
        if (jobtitle == null)
        {
            return null;
        } else {
            return jobtitle;
        }
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getBusinessphone() {
        if (businessphone == null)
        {
            return null;
        } else {
            return businessphone;
        }
    }

    public void setBusinessphone(String businessphone) {
        this.businessphone = businessphone;
    }

    public String getAddress1() {
        if (address1 == null)
        {
            return null;
        } else {
            return address1;
        }
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        if (address2 == null)
        {
            return null;
        } else {
            return address2;
        }
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        if (city == null)
        {
            return null;
        } else {
            return city;
        }
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getNotes() {
        if (notes == null)
        {
            return null;
        } else {
            return notes;
        }
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<UserRoles> getUserroles() {
        return userroles;
    }

    public void setUserroles(List<UserRoles> userroles) {
        this.userroles = userroles;
    }

    public List<Useremail> getUseremails() {
        return useremails;
    }

    public void setUseremails(List<Useremail> useremails) {
        this.useremails = useremails;
    }

    @JsonIgnore
    public List<SimpleGrantedAuthority> getAuthority() {
        List<SimpleGrantedAuthority> rtnList = new ArrayList<>();

        for (UserRoles r : this.userroles) {
            String myRole = "ROLE_" + r.getRole()
                                       .getName()
                                       .toUpperCase();
            rtnList.add(new SimpleGrantedAuthority(myRole));
        }

        return rtnList;
    }

    @Override
    public String toString() {
        return "User{" + "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", primaryemail='" + primaryemail +
                ", factoring='" + factoring +
                ", company='" + company +
                ", mrms='" + mrms +
                ", lastname='" + lastname +
                ", firstname='" + firstname +
                ", jobtitle='" + jobtitle +
                ", businessphone='" + businessphone +
                ", address1='" + address1 +
                ", address2='" + address2 +
                ", city='" + city +
                ", state='" + state +
                ", postalcode='" + postalcode +
                ", notes='" + notes +
                '\'' + '}';
    }
}
