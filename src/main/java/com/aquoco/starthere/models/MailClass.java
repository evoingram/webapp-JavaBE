package com.aquoco.starthere.models;

import com.aquoco.starthere.logging.Loggable;

import javax.persistence.*;


/*
 * mailclass table fields: mcid, mailclass, description
 */
@Loggable
@Entity
@Table(name = "mailclass")
public class MailClass extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long mcid;

    @Column(nullable = false,
            unique = true)
    private String mailclass;

    @Column(nullable = false)
    private String description;


    public MailClass() {
    }

    public MailClass(String mailclass, String description) {

        this.mailclass = mailclass;
        this.description = description;

    }

    public long getMcid() {
        return mcid;
    }

    public void setMcid(long mcid) {
        this.mcid = mcid;
    }

    public String getMailclass() {
        return mailclass;
    }

    public void setMailclass(String mailclass) {
        this.mailclass = mailclass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MailClass{" +
                "mcid=" + mcid +
                ", mailclass='" + mailclass + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
