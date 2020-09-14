package com.aquoco.starthere.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * examtypes table fields: eid, examination, ecode
 */
public class ExamType extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long eid;

    @Column(nullable = false,
            unique = true)
    private String examination;

    @Column(nullable = false,
            unique = true)
    private String ecode;

    public ExamType() {
    }

    public ExamType(String examination, String ecode) {

        this.examination = examination;
        this.ecode = ecode;
    }

    public long getEid() {
        return eid;
    }

    public void setEid(long eid) {
        this.eid = eid;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }

    @Override
    public String toString() {
        return "ExamType{" +
                "eid=" + eid +
                ", examination='" + examination + '\'' +
                ", ecode='" + ecode + '\'' +
                '}';
    }
}
