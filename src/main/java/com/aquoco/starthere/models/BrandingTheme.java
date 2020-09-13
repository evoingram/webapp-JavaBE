package com.aquoco.starthere.models;

import com.aquoco.starthere.logging.Loggable;

import javax.persistence.*;
import java.util.List;

@Loggable
@Entity
@Table(name = "brandingthemes")
public class BrandingTheme
        extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long btid;

    @Column(nullable = false,
            unique = true)
    private String brandingtheme;


    public BrandingTheme() {
    }

    public BrandingTheme(String brandingtheme) {
        this.brandingtheme = brandingtheme;
    }

    public long getBtid() {
        return btid;
    }

    public void setBtid(long btid) {
        this.btid = btid;
    }

    public String getBrandingtheme() {
        return brandingtheme;
    }

    public void setBrandingtheme(String brandingtheme) {
        this.brandingtheme = brandingtheme;
    }

    @Override
    public String toString() {
        return "BrandingTheme{" +
                "btid=" + btid +
                ", brandingtheme='" + brandingtheme + '\'' +
                '}';
    }

}
