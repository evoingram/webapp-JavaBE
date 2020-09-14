package com.aquoco.starthere.models;

import com.aquoco.starthere.logging.Loggable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
 * citations table fields:  chid, findcitation, longcitation,
 * chcategory, webaddress
 */
@Loggable
@Entity
@Table(name = "citations")
public class Citation extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long citationsid;

    @Column(nullable = false)
    private String findcitation;

    @Column(nullable = false)
    private String longcitation;

    @Column(nullable = false)
    private String chcategory;

    @Column(nullable = false)
    private String webaddress;


    public Citation() {
    }

    public Citation(String findcitation,
               String longcitation,
               String chcategory,
               String webaddress) {
        this.findcitation = findcitation;
        this.longcitation = longcitation;
        this.chcategory = chcategory;
        this.webaddress = webaddress;
    }

    public long getCitationsid() {
        return citationsid;
    }

    public void setCitationsid(long uscid) {
        this.citationsid = citationsid;
    }

    public String getFindcitation() {
        return findcitation;
    }

    public void setFindcitation(String findcitation) {
        this.findcitation = findcitation;
    }

    public String getLongcitation() {
        return longcitation;
    }

    public void setLongcitation(String longcitation) {
        this.longcitation = longcitation;
    }

    public String getChcategory() {
        return chcategory;
    }

    public void setChcategory(String chcategory) {
        this.chcategory = chcategory;
    }

    public String getWebaddress() {
        return webaddress;
    }

    public void setWebaddress(String webaddress) {
        this.webaddress = webaddress;
    }

    @Override
    public String toString() {
        return "Citation{" +
                "citationsid=" + citationsid +
                ", findcitation='" + findcitation + '\'' +
                ", longcitation='" + longcitation + '\'' +
                ", chcategory='" + chcategory + '\'' +
                ", webaddress='" + webaddress + '\'' +
                '}';
    }



    
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long citationsid;

    @OneToMany(mappedBy = "citation",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("citation")
    private List<Citation> usccites = new ArrayList<>();

    @OneToMany(mappedBy = "citation",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("citation")
    private List<Citation> citlinks = new ArrayList<>();

    @OneToMany(mappedBy = "citation",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("citation")
    private List<Courtdate> courtdates = new ArrayList<>();

    public Citation() {
    }

    public Citation(List<Citation> usccites,
                    List<Citation> citlinks,
                    List<Courtdate> courtdates) {
        for (Citation usccitations : usccites) {
            usccitations.setUser(this);
        }
        this.usccites = usccites;
        for (Citation citlinkcitations : citlinks) {
            citlinkcitations.setUser(this);
        }
        this.citlinks = citlinks;
        for (Courtdate courtdates1 : courtdates) {
            courtdates1.setUser(this);
        }
        this.courtdates = courtdates;
    }

    @Override
    public String toString() {
        return "Citation{" +
                "citationsid=" + citationsid +
                ", usccites=" + usccites +
                ", citlinks=" + citlinks +
                ", courtdates=" + courtdates +
                '}';
    }

     */
}
