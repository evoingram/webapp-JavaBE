package com.aquoco.starthere.services;

import com.aquoco.starthere.exceptions.ResourceFoundException;
import com.aquoco.starthere.exceptions.ResourceNotFoundException;
import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.PackageType;
import com.aquoco.starthere.repository.PackageTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/*
 * packagetype table fields: ptid, packagetype, description
 */
@Loggable
@Service(value = "packagetypeService")
public class PackageTypeServiceImpl implements PackageTypeService {

    @Autowired
    private PackageTypeRepository ptrepo;

    public PackageType findPackagetypeById(long id) throws
            ResourceNotFoundException {
        return ptrepo.findById(id)
                     .orElseThrow(() -> new ResourceNotFoundException("Package Type ID " + id + " not found!"));
    }

    @Override
    public PackageType findByPackagetype(String packagetype) {
        return ptrepo.findByPackagetype(packagetype);
    }

    @Override
    public PackageType findByDescription(String description) {
        return ptrepo.findByDescription(description);
    }

    @Override
    public List<PackageType> findByPackagetypeContainingIgnoreCase(String packagetype,
                                                               Pageable pageable) {
        return ptrepo.findByPackagetypeContainingIgnoreCase(packagetype, pageable);
    }

    @Override
    public List<PackageType> findByDescriptionContainingIgnoreCase(String description,
                                                                 Pageable pageable) {
        return ptrepo.findByDescriptionContainingIgnoreCase(description, pageable);
    }

    @Override
    public List<PackageType> findAll(Pageable pageable) {
        List<PackageType> list = new ArrayList<>();
        ptrepo.findAll(pageable)
              .iterator()
              .forEachRemaining(list::add);
        return list;
    }

    @Override
    public List<PackageType> findByPackageTypeContaining(String packagetype,
                                                         Pageable pageable) {
        return ptrepo.findByPackagetypeContaining(packagetype, pageable);
    }

    @Transactional
    @Override
    public void delete(long id, boolean isAdmin) {

        if (isAdmin) {
            ptrepo.findById(id)
                  .orElseThrow(() -> new ResourceNotFoundException("ptid " + id + " not found!"));
            ptrepo.deleteById(id);
        }
    }

    @Transactional
    @Override
    public PackageType save(PackageType packageType, boolean isAdmin) {

        if (isAdmin) {

            if (ptrepo.findByPackagetype(packageType.getPackagetype()) != null) {
                throw new ResourceFoundException(packageType.getPackagetype() + " is already taken!");
            }

            PackageType newPT = new PackageType();
            newPT.setPackagetype(packageType.getPackagetype());
            newPT.setDescription(packageType.getDescription());

            if (newPT.getPackagetype() != null) {
                newPT.setDescription(packageType.getPackagetype());
            }

            if (newPT.getDescription() != null) {
                newPT.setDescription(packageType.getDescription());
            }

            return ptrepo.save(newPT);
        }

        return null;
    }

    @Transactional
    @Override
    public PackageType update(PackageType packageType,
                            long id,
                            boolean isAdmin) {

        if (isAdmin) {

            PackageType currentPT = findPackagetypeById(id);


            if(packageType.getPackagetype() != null) {
                currentPT.setPackagetype(packageType.getPackagetype());
            }

            if(packageType.getDescription() != null) {
                packageType.setDescription(packageType.getDescription());
            }

            return ptrepo.save(currentPT);

        } else {
            throw new ResourceNotFoundException(id + " not current package type");
        }

    }
}
