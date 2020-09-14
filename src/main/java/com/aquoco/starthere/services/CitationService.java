package com.aquoco.starthere.services;

import com.aquoco.starthere.models.Citation;
import org.springframework.data.domain.Pageable;

import java.util.List;

/*
 * citations table fields:  chid, findcitation, longcitation,
 * chcategory, webaddress
 */
public interface CitationService {

    List<Citation> findAll(Pageable pageable);

    Citation findCitationById(long id);

    Citation findByFindcitation(String findcitation);

    Citation findByLongcitation(String longcitation);

    Citation findByChcategory(String chcategory);

    Citation findByWebaddress(String webaddress);

    List<Citation> findByFindcitationContainingIgnoreCase(String findcitation, Pageable pageable);

    List<Citation> findByLongcitationContainingIgnoreCase(String longcitation, Pageable pageable);

    List<Citation> findByChcategoryContainingIgnoreCase(String chcategory, Pageable pageable);

    List<Citation> findByWebaddressContainingIgnoreCase(String webaddress, Pageable pageable);

    void delete(long id, boolean isAdmin);

    Citation save(Citation citation, boolean isAdmin);

    Citation update(Citation citation,
                             long id,
                             boolean isAdmin);

}
