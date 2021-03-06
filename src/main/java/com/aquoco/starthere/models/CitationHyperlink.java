package com.aquoco.starthere.models;

import com.aquoco.starthere.logging.Loggable;

import javax.persistence.*;
/*
* citationhyperlinks table fields:  chid, findcitation, longcitation,
* chcategory, webaddress
 */
@Loggable
@Entity
@Table(name = "citationhyperlinks")
public class CitationHyperlink
        extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long chid;

    @Column(nullable = false)
    private String findcitation;

    @Column(nullable = false)
    private String longcitation;

    @Column(nullable = false)
    private String chcategory;

    @Column(nullable = false)
    private String webaddress;


    public CitationHyperlink() {
    }

    public CitationHyperlink(String findcitation,
                             String longcitation,
                             String chcategory,
                             String webaddress) {
        this.findcitation = findcitation;
        this.longcitation = longcitation;
        this.chcategory = chcategory;
        this.webaddress = webaddress;
    }

    public long getChid() {
        return chid;
    }

    public void setChid(long chid) {
        this.chid = chid;
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
        return "CitationHyperlink{" +
                "chid=" + chid +
                ", findcitation='" + findcitation + '\'' +
                ", longcitation='" + longcitation + '\'' +
                ", chcategory='" + chcategory + '\'' +
                ", webaddress='" + webaddress + '\'' +
                '}';
    }
}
