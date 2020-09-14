package com.aquoco.starthere.services;

import com.aquoco.starthere.exceptions.ResourceFoundException;
import com.aquoco.starthere.exceptions.ResourceNotFoundException;
import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.Citation;
import com.aquoco.starthere.repository.CitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/*
 * citations table fields:  citationsid, findcitation, longcitation,
 * chcategory, webaddress
 */
@Loggable
@Service(value = "citationService")
public class CitationServiceImpl
        implements CitationService  {

    @Autowired
    private CitationRepository citationrepo;

    @Override
    public List<Citation> findAll(Pageable pageable) {
        List<Citation> list = new ArrayList<>();
        citationrepo.findAll(pageable)
              .iterator()
              .forEachRemaining(list::add);
        return list;
    }

    public Citation findCitationById(long id) throws
            ResourceNotFoundException {
        return citationrepo.findById(id)
                     .orElseThrow(() -> new ResourceNotFoundException("Citation ID " + id + " not found!"));
    }

    @Override
    public Citation findByFindcitation(String findcitation) throws
            ResourceNotFoundException {

        if (citationrepo.findByFindcitation(findcitation.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Findcitation " + findcitation + " not found!");
        }
        return citationrepo.findByFindcitation(findcitation.toLowerCase());

    }

    @Override
    public List<Citation> findByFindcitationContainingIgnoreCase(String findcitation,
                                                                          Pageable pageable) {
        return citationrepo.findByFindcitationContainingIgnoreCase(findcitation, pageable);
    }

    @Override
    public Citation findByLongcitation(String longcitation) throws
            ResourceNotFoundException {

        if (citationrepo.findByLongcitation(longcitation.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Findcitation " + longcitation + " not found!");
        }
        return citationrepo.findByLongcitation(longcitation.toLowerCase());

    }

    @Override
    public List<Citation> findByLongcitationContainingIgnoreCase(String longcitation,
                                                                          Pageable pageable) {
        return citationrepo.findByLongcitationContainingIgnoreCase(longcitation,
                                                             pageable);
    }

    @Override
    public Citation findByChcategory(String chcategory) throws
            ResourceNotFoundException {

        if (citationrepo.findByChcategory(chcategory.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Findcitation " + chcategory + " not found!");
        }
        return citationrepo.findByChcategory(chcategory.toLowerCase());

    }

    @Override
    public List<Citation> findByChcategoryContainingIgnoreCase(String chcategory,
                                                                        Pageable pageable) {
        return citationrepo.findByChcategoryContainingIgnoreCase(chcategory,
                                                           pageable);
    }

    @Override
    public Citation findByWebaddress(String webaddress) throws
            ResourceNotFoundException {

        if (citationrepo.findByWebaddress(webaddress.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Findcitation " + webaddress + " not found!");
        }
        return citationrepo.findByWebaddress(webaddress.toLowerCase());

    }

    @Override
    public List<Citation> findByWebaddressContainingIgnoreCase(String webaddress,
                                                                        Pageable pageable) {
        return citationrepo.findByWebaddressContainingIgnoreCase(webaddress,
                                                           pageable);
    }

    @Transactional
    @Override
    public void delete(long id, boolean isAdmin) {

        if (isAdmin) {
            citationrepo.findById(id)
                  .orElseThrow(() -> new ResourceNotFoundException("chid " + id + " not found!"));
            citationrepo.deleteById(id);
        }
    }

    @Transactional
    @Override
    public Citation save(Citation citation, boolean isAdmin) {

        if (isAdmin) {

            if (citationrepo.findByFindcitation(citation.getFindcitation()) != null) {
                throw new ResourceFoundException(citation.getFindcitation() + " is already taken!");
            }

            Citation newCH = new Citation();
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


            return citationrepo.save(newCH);
        }

        return null;
    }

    @Transactional
    @Override
    public Citation update(Citation citation,
                                    long id,
                                    boolean isAdmin) {

        if (isAdmin) {

            Citation currentCH = findCitationById(id);

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

            return citationrepo.save(currentCH);

        } else {
            throw new ResourceNotFoundException(id + " not current citation");
        }


    }

}
