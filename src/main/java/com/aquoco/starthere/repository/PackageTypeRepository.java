package com.aquoco.starthere.repository;

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

    PackageType findByDescription(String description);

    List<PackageType> findByPackagetypeContainingIgnoreCase(String packagetype,
                                                                Pageable pageable);

    List<PackageType> findByDescriptionContainingIgnoreCase(String description,
                                                            Pageable pageable);

    List<PackageType> findByPackagetypeContaining(String packagetype,
                                                  Pageable pageable);
}