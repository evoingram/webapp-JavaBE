package com.aquoco.starthere.repository;

import com.aquoco.starthere.models.BrandingTheme;
import com.aquoco.starthere.models.PackageType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/*
 * packagetype table fields: ptid, packagetype, description
 */
public interface PackageTypeRepository
        extends PagingAndSortingRepository<PackageType, Long> {

    PackageType findByPackagetype(String packagetype);

    List<PackageType> findByPackagetypeContainingIgnoreCase(String packagetype,
                                                                Pageable pageable);

    List<PackageType> findByDescriptionContainingIgnoreCase(String description,
                                                            Pageable pageable);
}