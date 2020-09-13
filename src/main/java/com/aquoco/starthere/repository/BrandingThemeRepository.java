package com.aquoco.starthere.repository;

import com.aquoco.starthere.models.BrandingTheme;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/*
 * brandingtheme table fields: btid, brandingtheme
 */
public interface BrandingThemeRepository
        extends PagingAndSortingRepository<BrandingTheme, Long> {

    BrandingTheme findByBrandingtheme(String brandingtheme);

    List<BrandingTheme> findByBrandingthemeContainingIgnoreCase(String brandingtheme, Pageable pageable);

}
