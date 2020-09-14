package com.aquoco.starthere.repository;


import com.aquoco.starthere.models.Citation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/*
 * citations table fields:  chid, findcitation, longcitation,
 * chcategory, webaddress
 */
public interface CitationRepository
        extends PagingAndSortingRepository<Citation, Long> {

    Citation findByFindcitation(String findcitation);

    Citation findByLongcitation(String longcitation);

    Citation findByChcategory(String chcategory);

    Citation findByWebaddress(String webaddress);

    List<Citation> findByFindcitationContainingIgnoreCase(String findcitation, Pageable pageable);

    List<Citation> findByLongcitationContainingIgnoreCase(String longcitation, Pageable pageable);

    List<Citation> findByChcategoryContainingIgnoreCase(String chcategory, Pageable pageable);

    List<Citation> findByWebaddressContainingIgnoreCase(String webaddress, Pageable pageable);
}
