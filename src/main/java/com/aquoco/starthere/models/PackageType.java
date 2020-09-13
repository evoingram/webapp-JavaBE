package com.aquoco.starthere.models;

import com.aquoco.starthere.logging.Loggable;

import javax.persistence.*;

@Loggable
@Entity
@Table(name = "packagetype")
public class PackageType extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ptid;

    @Column(nullable = false,
            unique = true)
    private String packagetype;

    @Column(nullable = false)
    private String description;

    public PackageType() {
    }

    public PackageType(String packagetype, String description) {

        this.packagetype = packagetype;
        this.description = description;
    }

    public long getPtid() {
        return ptid;
    }

    public void setPtid(long ptid) {
        this.ptid = ptid;
    }

    public String getPackagetype() {
        return packagetype;
    }

    public void setPackagetype(String packagetype) {
        this.packagetype = packagetype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PackageType{" +
                "ptid=" + ptid +
                ", packagetype='" + packagetype + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
