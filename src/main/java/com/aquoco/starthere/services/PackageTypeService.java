package com.aquoco.starthere.services;

import com.aquoco.starthere.models.PackageType;
import org.springframework.data.domain.Pageable;

import java.util.List;

/*
 * packagetype table fields: ptid, packagetype, description
 */
public interface PackageTypeService {

    List<PackageType> findAll(Pageable pageable);

    List<PackageType> findByPackageTypeContaining(String packagetype, Pageable pageable);

    List<PackageType> findByPackagetypeContainingIgnoreCase(String packagetype, Pageable pageable);

    List<PackageType> findByDescriptionContainingIgnoreCase(String packagetype, Pageable pageable);

    PackageType findPackagetypeById(long id);

    PackageType findByPackagetype(String packagetype);

    PackageType findByDescription(String description);

    void delete(long id, boolean isAdmin);

    PackageType save(PackageType packagetype, boolean isAdmin);

    PackageType update(PackageType packagetype,
                         long id,
                         boolean isAdmin);
}
