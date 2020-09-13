package com.aquoco.starthere.models;

import com.aquoco.starthere.logging.Loggable;

import javax.persistence.*;

/*
    * rate table fields:  ratesid, code, inventoryratecode, productname, description, rate
*/
@Loggable
@Entity
@Table(name = "rates")
public class Rate
        extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ratesid;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false, unique = true)
    private String inventoryratecode;

    @Column(nullable = false, unique = true)
    private String productname;

    @Column(nullable = false, unique = true)
    private String description;

    @Column(nullable = false)
    private Double rate;

    public Rate() {
    }

    public Rate(String code,
                String inventoryratecode,
                String productname,
                String description,
                Double rate) {
        this.code = code;
        this.inventoryratecode = inventoryratecode;
        this.productname = productname;
        this.description = description;
        this.rate = rate;
    }

    public long getRatesid() {
        return ratesid;
    }

    public void setRatesid(long ratesid) {
        this.ratesid = ratesid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInventoryratecode() {
        return inventoryratecode;
    }

    public void setInventoryratecode(String inventoryratecode) {
        this.inventoryratecode = inventoryratecode;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "ratesid=" + ratesid +
                ", code='" + code + '\'' +
                ", inventoryratecode='" + inventoryratecode + '\'' +
                ", productname='" + productname + '\'' +
                ", description='" + description + '\'' +
                ", rate=" + rate +
                '}';
    }
}
