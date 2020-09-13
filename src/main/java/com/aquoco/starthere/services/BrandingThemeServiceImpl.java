package com.aquoco.starthere.services;

import com.aquoco.starthere.exceptions.ResourceFoundException;
import com.aquoco.starthere.exceptions.ResourceNotFoundException;
import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.BrandingTheme;
import com.aquoco.starthere.repository.BrandingThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/*
 * brandingtheme table fields: btid, brandingtheme
 */
@Loggable
@Service(value = "brandingThemeService")
public class BrandingThemeServiceImpl implements BrandingThemeService {

    @Autowired
    private BrandingThemeRepository btrepo;


    public BrandingTheme findBrandingthemeById(long id) throws
            ResourceNotFoundException {
        return btrepo.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Branding Theme ID " + id + " not found!"));
    }

    @Override
    public BrandingTheme findByBrandingtheme(String brandingtheme) {
        return null;
    }

    @Override
    public List<BrandingTheme> findByBrandingthemeContaining(String brandingtheme,
                                           Pageable pageable) {
        return btrepo.findByBrandingthemeContainingIgnoreCase(brandingtheme,
                                                            pageable);
    }

    @Override
    public List<BrandingTheme> findAll(Pageable pageable) {
        List<BrandingTheme> list = new ArrayList<>();
        btrepo.findAll(pageable)
                 .iterator()
                 .forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public void delete(long id, boolean isAdmin) {

        if (isAdmin) {
            btrepo.findById(id)
                  .orElseThrow(() -> new ResourceNotFoundException("btid " + id + " not found!"));
            btrepo.deleteById(id);
        }
    }

    @Transactional
    @Override
    public BrandingTheme save(BrandingTheme brandingtheme, boolean isAdmin) {

        if (isAdmin) {

            if (btrepo.findByBrandingtheme(brandingtheme.getBrandingtheme()) != null) {
                throw new ResourceFoundException(brandingtheme.getBrandingtheme() + " is already taken!");
            }

            BrandingTheme newBT = new BrandingTheme();
            newBT.setBrandingtheme(brandingtheme.getBrandingtheme());

            if (newBT.getBrandingtheme() != null) {
                newBT.setBrandingtheme(brandingtheme.getBrandingtheme());
            }

            return btrepo.save(newBT);
        }

        return null;
    }

    @Transactional
    @Override
    public BrandingTheme update(BrandingTheme brandingTheme,
                       long id,
                       boolean isAdmin) {

        if (isAdmin) {

            BrandingTheme currentBT = findBrandingthemeById(id);


            if(brandingTheme.getBrandingtheme() != null) {
                currentBT.setBrandingtheme(brandingTheme.getBrandingtheme());
            }


            return btrepo.save(currentBT);

        } else {
            throw new ResourceNotFoundException(id + " not current branding theme");
        }


    }

}
