package com.aquoco.starthere.models;

import com.aquoco.starthere.logging.Loggable;

import javax.persistence.*;

@Loggable
@Entity
@Table(name = "cases")
public class Case extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long casesid;

    @Column(nullable = false)
    private String party1;

    @Column(nullable = false)
    private String party1name;

    @Column(nullable = false)
    private String party2;

    @Column(nullable = false)
    private String party2name;

    @Column(nullable = false)
    private String casenumber1;

    @Column(nullable = false)
    private String casenumber2;

    @Column(nullable = false)
    private String jurisdiction;

    @Column(nullable = false)
    private String notes;


    public Case() {
    }

    public Case(String party1,
                String party1name,
                String party2,
                String party2name,
                String casenumber1,
                String casenumber2,
                String jurisdiction,
                String notes) {
        this.party1 = party1;
        this.party1name = party1name;
        this.party2 = party2;
        this.party2name = party2name;
        this.casenumber1 = casenumber1;
        this.casenumber2 = casenumber2;
        this.jurisdiction = jurisdiction;
        this.notes = notes;
    }

    public long getCasesid() {
        return casesid;
    }

    public void setCasesid(long casesid) {
        this.casesid = casesid;
    }

    public String getParty1() {
        return party1;
    }

    public void setParty1(String party1) {
        this.party1 = party1;
    }

    public String getParty1name() {
        return party1name;
    }

    public void setParty1name(String party1name) {
        this.party1name = party1name;
    }

    public String getParty2() {
        return party2;
    }

    public void setParty2(String party2) {
        this.party2 = party2;
    }

    public String getParty2name() {
        return party2name;
    }

    public void setParty2name(String party2name) {
        this.party2name = party2name;
    }

    public String getCasenumber1() {
        return casenumber1;
    }

    public void setCasenumber1(String casenumber1) {
        this.casenumber1 = casenumber1;
    }

    public String getCasenumber2() {
        return casenumber2;
    }

    public void setCasenumber2(String casenumber2) {
        this.casenumber2 = casenumber2;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Case{" +
                "casesid=" + casesid +
                ", party1='" + party1 + '\'' +
                ", party1name='" + party1name + '\'' +
                ", party2='" + party2 + '\'' +
                ", party2name='" + party2name + '\'' +
                ", casenumber1='" + casenumber1 + '\'' +
                ", casenumber2='" + casenumber2 + '\'' +
                ", jurisdiction='" + jurisdiction + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
