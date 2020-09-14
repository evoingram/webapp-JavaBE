package com.aquoco.starthere.repository;


import com.aquoco.starthere.models.USC;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/*
 * usc table fields:  chid, findcitation, longcitation,
 * chcategory, webaddress
 */
public interface USCRepository
        extends PagingAndSortingRepository<USC, Long> {

    USC findByFindcitation(String findcitation);

    USC findByLongcitation(String longcitation);

    USC findByChcategory(String chcategory);

    USC findByWebaddress(String webaddress);

    List<USC> findByFindcitationContainingIgnoreCase(String findcitation, Pageable pageable);

    List<USC> findByLongcitationContainingIgnoreCase(String longcitation, Pageable pageable);

    List<USC> findByChcategoryContainingIgnoreCase(String chcategory, Pageable pageable);

    List<USC> findByWebaddressContainingIgnoreCase(String webaddress, Pageable pageable);
}
