package com.aquoco.starthere.services;

import com.aquoco.starthere.exceptions.ResourceFoundException;
import com.aquoco.starthere.exceptions.ResourceNotFoundException;
import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.USC;
import com.aquoco.starthere.repository.USCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/*
 * usc table fields:  uscid, findcitation, longcitation,
 * chcategory, webaddress
 */
@Loggable
@Service(value = "uscService")
public class USCServiceImpl
        implements USCService  {

    @Autowired
    private USCRepository uscrepo;

    @Override
    public List<USC> findAll(Pageable pageable) {
        List<USC> list = new ArrayList<>();
        uscrepo.findAll(pageable)
                    .iterator()
                    .forEachRemaining(list::add);
        return list;
    }

    public USC findUSCById(long id) throws
            ResourceNotFoundException {
        return uscrepo.findById(id)
                           .orElseThrow(() -> new ResourceNotFoundException("USC ID " + id + " not found!"));
    }

    @Override
    public USC findByFindcitation(String findcitation) throws
            ResourceNotFoundException {

        if (uscrepo.findByFindcitation(findcitation.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Findcitation " + findcitation + " not found!");
        }
        return uscrepo.findByFindcitation(findcitation.toLowerCase());

    }

    @Override
    public List<USC> findByFindcitationContainingIgnoreCase(String findcitation,
                                                                 Pageable pageable) {
        return uscrepo.findByFindcitationContainingIgnoreCase(findcitation, pageable);
    }

    @Override
    public USC findByLongcitation(String longcitation) throws
            ResourceNotFoundException {

        if (uscrepo.findByLongcitation(longcitation.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Findcitation " + longcitation + " not found!");
        }
        return uscrepo.findByLongcitation(longcitation.toLowerCase());

    }

    @Override
    public List<USC> findByLongcitationContainingIgnoreCase(String longcitation,
                                                                 Pageable pageable) {
        return uscrepo.findByLongcitationContainingIgnoreCase(longcitation,
                                                                   pageable);
    }

    @Override
    public USC findByChcategory(String chcategory) throws
            ResourceNotFoundException {

        if (uscrepo.findByChcategory(chcategory.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Findcitation " + chcategory + " not found!");
        }
        return uscrepo.findByChcategory(chcategory.toLowerCase());

    }

    @Override
    public List<USC> findByChcategoryContainingIgnoreCase(String chcategory,
                                                               Pageable pageable) {
        return uscrepo.findByChcategoryContainingIgnoreCase(chcategory,
                                                                 pageable);
    }

    @Override
    public USC findByWebaddress(String webaddress) throws
            ResourceNotFoundException {

        if (uscrepo.findByWebaddress(webaddress.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Findcitation " + webaddress + " not found!");
        }
        return uscrepo.findByWebaddress(webaddress.toLowerCase());

    }

    @Override
    public List<USC> findByWebaddressContainingIgnoreCase(String webaddress,
                                                               Pageable pageable) {
        return uscrepo.findByWebaddressContainingIgnoreCase(webaddress,
                                                                 pageable);
    }

    @Transactional
    @Override
    public void delete(long id, boolean isAdmin) {

        if (isAdmin) {
            uscrepo.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("chid " + id + " not found!"));
            uscrepo.deleteById(id);
        }
    }

    @Transactional
    @Override
    public USC save(USC citation, boolean isAdmin) {

        if (isAdmin) {

            if (uscrepo.findByFindcitation(citation.getFindcitation()) != null) {
                throw new ResourceFoundException(citation.getFindcitation() + " is already taken!");
            }

            USC newCH = new USC();
            newCH.setFindcitation(citation.getFindcitation());

            if (newCH.getFindcitation() != null) {
                newCH.setFindcitation(citation.getFindcitation());
            }
            newCH.setLongcitation(citation.getLongcitation());

            if (newCH.getLongcitation() != null) {
                newCH.setLongcitation(citation.getLongcitation());
            }

            newCH.setChcategory(citation.getChcategory());

            if (newCH.getChcategory() != null) {
                newCH.setChcategory(citation.getChcategory());
            }

            newCH.setWebaddress(citation.getWebaddress());

            if (newCH.getWebaddress() != null) {
                newCH.setWebaddress(citation.getWebaddress());
            }


            return uscrepo.save(newCH);
        }

        return null;
    }

    @Transactional
    @Override
    public USC update(USC citation,
                           long id,
                           boolean isAdmin) {

        if (isAdmin) {

            USC currentCH = findUSCById(id);

            if(citation.getFindcitation() != null) {
                currentCH.setFindcitation(citation.getFindcitation());
            }
            if(citation.getLongcitation() != null) {
                currentCH.setLongcitation(citation.getLongcitation());
            }

            if(citation.getChcategory() != null) {
                currentCH.setChcategory(citation.getChcategory());
            }

            if(citation.getWebaddress() != null) {
                currentCH.setWebaddress(citation.getWebaddress());
            }

            return uscrepo.save(currentCH);

        } else {
            throw new ResourceNotFoundException(id + " not current usc citation");
        }


    }

}
