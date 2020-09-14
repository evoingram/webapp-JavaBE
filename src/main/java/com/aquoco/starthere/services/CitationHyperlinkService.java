package com.aquoco.starthere.services;

import com.aquoco.starthere.models.CitationHyperlink;
import org.springframework.data.domain.Pageable;

import java.util.List;

/*
 * citationhyperlinks table fields:  chid, findcitation, longcitation,
 * chcategory, webaddress
 */
public interface CitationHyperlinkService {

    List<CitationHyperlink> findAll(Pageable pageable);

    CitationHyperlink findCitationhyperlinkById(long id);

    CitationHyperlink findByFindcitation(String findcitation);

    CitationHyperlink findByLongcitation(String longcitation);

    CitationHyperlink findByChcategory(String chcategory);

    CitationHyperlink findByWebaddress(String webaddress);

    List<CitationHyperlink> findByFindcitationdContainingIgnoreCase(String findcitation, Pageable pageable);

    List<CitationHyperlink> findByLongcitationContainingIgnoreCase(String longcitation, Pageable pageable);

    List<CitationHyperlink> findByChcategoryContainingIgnoreCase(String chcategory, Pageable pageable);

    List<CitationHyperlink> findByWebaddressContainingIgnoreCase(String webaddress, Pageable pageable);


    void delete(long id, boolean isAdmin);

    CitationHyperlink save(CitationHyperlink citationHyperlink, boolean isAdmin);

    CitationHyperlink update(CitationHyperlink citationHyperlink,
                         long id,
                         boolean isAdmin);

}
