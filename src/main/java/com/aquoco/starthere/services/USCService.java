package com.aquoco.starthere.services;

import com.aquoco.starthere.models.USC;
import org.springframework.data.domain.Pageable;

import java.util.List;

/*
 * usc table fields:  chid, findcitation, longcitation,
 * chcategory, webaddress
 */
public interface USCService {

    List<USC> findAll(Pageable pageable);

    USC findUSCById(long id);

    USC findByFindcitation(String findcitation);

    USC findByLongcitation(String longcitation);

    USC findByChcategory(String chcategory);

    USC findByWebaddress(String webaddress);

    List<USC> findByFindcitationContainingIgnoreCase(String findcitation, Pageable pageable);

    List<USC> findByLongcitationContainingIgnoreCase(String longcitation, Pageable pageable);

    List<USC> findByChcategoryContainingIgnoreCase(String chcategory, Pageable pageable);

    List<USC> findByWebaddressContainingIgnoreCase(String webaddress, Pageable pageable);

    void delete(long id, boolean isAdmin);

    USC save(USC citation, boolean isAdmin);

    USC update(USC citation,
                    long id,
                    boolean isAdmin);
}
