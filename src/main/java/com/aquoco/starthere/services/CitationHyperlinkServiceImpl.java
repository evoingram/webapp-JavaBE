package com.aquoco.starthere.services;

import com.aquoco.starthere.exceptions.ResourceFoundException;
import com.aquoco.starthere.exceptions.ResourceNotFoundException;
import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.CitationHyperlink;
import com.aquoco.starthere.repository.CitationHyperlinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/*
 * citationhyperlinks table fields:  chid, findcitation, longcitation,
 * chcategory, webaddress
 */
@Loggable
@Service(value = "citationhyperlinkService")
public class CitationHyperlinkServiceImpl
        implements CitationHyperlinkService {

    @Autowired
    private CitationHyperlinkRepository chrepo;

    @Override
    public List<CitationHyperlink> findAll(Pageable pageable) {
        List<CitationHyperlink> list = new ArrayList<>();
        chrepo.findAll(pageable)
              .iterator()
              .forEachRemaining(list::add);
        return list;
    }

    public CitationHyperlink findCitationhyperlinkById(long id) throws
            ResourceNotFoundException {
        return chrepo.findById(id)
                     .orElseThrow(() -> new ResourceNotFoundException("Citation Hyperlink ID " + id + " not found!"));
    }

    @Override
    public CitationHyperlink findByFindcitation(String findcitation) throws
            ResourceNotFoundException {

        if (chrepo.findByFindcitation(findcitation.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Findcitation " + findcitation + " not found!");
        }
        return chrepo.findByFindcitation(findcitation.toLowerCase());

    }

    @Override
    public List<CitationHyperlink> findByFindcitationContainingIgnoreCase(String findcitation,
                                                             Pageable pageable) {
        return chrepo.findByFindcitationContainingIgnoreCase(findcitation, pageable);
    }

    @Override
    public CitationHyperlink findByLongcitation(String longcitation) throws
            ResourceNotFoundException {

        if (chrepo.findByLongcitation(longcitation.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Findcitation " + longcitation + " not found!");
        }
        return chrepo.findByLongcitation(longcitation.toLowerCase());

    }

    @Override
    public List<CitationHyperlink> findByLongcitationContainingIgnoreCase(String longcitation,
                                                                Pageable pageable) {
        return chrepo.findByLongcitationContainingIgnoreCase(longcitation,
                                                             pageable);
    }

    @Override
    public CitationHyperlink findByChcategory(String chcategory) throws
            ResourceNotFoundException {

        if (chrepo.findByChcategory(chcategory.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Findcitation " + chcategory + " not found!");
        }
        return chrepo.findByChcategory(chcategory.toLowerCase());

    }

    @Override
    public List<CitationHyperlink> findByChcategoryContainingIgnoreCase(String chcategory,
                                                                        Pageable pageable) {
        return chrepo.findByChcategoryContainingIgnoreCase(chcategory,
                                                           pageable);
    }

    @Override
    public CitationHyperlink findByWebaddress(String webaddress) throws
            ResourceNotFoundException {

        if (chrepo.findByWebaddress(webaddress.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Findcitation " + webaddress + " not found!");
        }
        return chrepo.findByWebaddress(webaddress.toLowerCase());

    }

    @Override
    public List<CitationHyperlink> findByWebaddressContainingIgnoreCase(String webaddress,
                                                                        Pageable pageable) {
        return chrepo.findByWebaddressContainingIgnoreCase(webaddress,
                                                           pageable);
    }

    @Transactional
    @Override
    public void delete(long id, boolean isAdmin) {

        if (isAdmin) {
            chrepo.findById(id)
                  .orElseThrow(() -> new ResourceNotFoundException("chid " + id + " not found!"));
            chrepo.deleteById(id);
        }
    }

    @Transactional
    @Override
    public CitationHyperlink save(CitationHyperlink citationHyperlink, boolean isAdmin) {

        if (isAdmin) {

            if (chrepo.findByFindcitation(citationHyperlink.getFindcitation()) != null) {
                throw new ResourceFoundException(citationHyperlink.getFindcitation() + " is already taken!");
            }

            CitationHyperlink newCH = new CitationHyperlink();
            newCH.setFindcitation(citationHyperlink.getFindcitation());

            if (newCH.getFindcitation() != null) {
                newCH.setFindcitation(citationHyperlink.getFindcitation());
            }
            newCH.setLongcitation(citationHyperlink.getLongcitation());

            if (newCH.getLongcitation() != null) {
                newCH.setLongcitation(citationHyperlink.getLongcitation());
            }

            newCH.setChcategory(citationHyperlink.getChcategory());

            if (newCH.getChcategory() != null) {
                newCH.setChcategory(citationHyperlink.getChcategory());
            }

            newCH.setWebaddress(citationHyperlink.getWebaddress());

            if (newCH.getWebaddress() != null) {
                newCH.setWebaddress(citationHyperlink.getWebaddress());
            }


            return chrepo.save(newCH);
        }

        return null;
    }

    @Transactional
    @Override
    public CitationHyperlink update(CitationHyperlink citationHyperlink,
                                long id,
                                boolean isAdmin) {

        if (isAdmin) {

            CitationHyperlink currentCH = findCitationhyperlinkById(id);

            if(citationHyperlink.getFindcitation() != null) {
                currentCH.setFindcitation(citationHyperlink.getFindcitation());
            }
            if(citationHyperlink.getLongcitation() != null) {
                currentCH.setLongcitation(citationHyperlink.getLongcitation());
            }

            if(citationHyperlink.getChcategory() != null) {
                currentCH.setChcategory(citationHyperlink.getChcategory());
            }

            if(citationHyperlink.getWebaddress() != null) {
                currentCH.setWebaddress(citationHyperlink.getWebaddress());
            }

            return chrepo.save(currentCH);

        } else {
            throw new ResourceNotFoundException(id + " not current citationhyperlink");
        }


    }

}
