package com.aquoco.starthere.models;

import com.aquoco.starthere.logging.Loggable;

import javax.persistence.*;

/*
 * style table fields: sid, stylename
 */
@Loggable
@Entity
@Table(name = "stylenames")
public class Style extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sid;

    @Column(nullable = false,
            unique = true)
    private String stylename;


    public Style() {
    }

    public Style(String stylename) {
        this.stylename = stylename;
    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public String getStylename() {
        return stylename;
    }

    public void setStylename(String stylename) {
        this.stylename = stylename;
    }

    @Override
    public String toString() {
        return "Style{" +
                "sid=" + sid +
                ", stylename='" + stylename + '\'' +
                '}';
    }
}
