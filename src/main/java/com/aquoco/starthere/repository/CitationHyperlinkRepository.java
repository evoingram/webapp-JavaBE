package com.aquoco.starthere.repository;

import com.aquoco.starthere.models.CitationHyperlink;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/*
 * citationhyperlinks table fields:  chid, findcitation, longcitation,
 * chcategory, webaddress
 */
public interface CitationHyperlinkRepository
        extends PagingAndSortingRepository<CitationHyperlink, Long> {

    CitationHyperlink findByFindcitation(String findcitation);

    CitationHyperlink findByLongcitation(String longcitation);

    CitationHyperlink findByChcategory(String chcategory);

    CitationHyperlink findByWebaddress(String webaddress);

    List<CitationHyperlink> findByFindcitationContainingIgnoreCase(String findcitation, Pageable pageable);

    List<CitationHyperlink> findByLongcitationContainingIgnoreCase(String longcitation, Pageable pageable);

    List<CitationHyperlink> findByChcategoryContainingIgnoreCase(String chcategory, Pageable pageable);

    List<CitationHyperlink> findByWebaddressContainingIgnoreCase(String webaddress, Pageable pageable);

}
