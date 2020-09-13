package com.aquoco.starthere.services;

import com.aquoco.starthere.models.BrandingTheme;
import org.springframework.data.domain.Pageable;

import java.util.List;

/*
 * brandingtheme table fields: btid, brandingtheme
 */
public interface BrandingThemeService {

    List<BrandingTheme> findAll(Pageable pageable);

    List<BrandingTheme> findByBrandingthemeContaining(String brandingtheme, Pageable pageable);

    BrandingTheme findBrandingthemeById(long id);

    BrandingTheme findByBrandingtheme(String brandingtheme);

    void delete(long id, boolean isAdmin);

    BrandingTheme save(BrandingTheme brandingtheme, boolean isAdmin);

    BrandingTheme update(BrandingTheme brandingtheme,
                long id,
                boolean isAdmin);

}
