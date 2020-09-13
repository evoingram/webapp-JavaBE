package com.aquoco.starthere.services;

import com.aquoco.starthere.models.Rate;
import org.springframework.data.domain.Pageable;

import java.util.List;

/*
 * rate table fields:  ratesid, code, inventoryratecode, productname, description, rate
*/
public interface RateService {

    Rate findByRate(Double rate);

    List<Rate> findAll(Pageable pageable);

    List<Rate> findByRateContaining(Double rate, Pageable pageable);

    List<Rate> findByCodeContainingIgnoreCase(String code, Pageable pageable);

    List<Rate> findByInventoryratecodeContainingIgnoreCase(String inventoryratecode, Pageable pageable);

    List<Rate> findByProductnameContainingIgnoreCase(String productname, Pageable pageable);

    List<Rate> findByDescriptionContainingIgnoreCase(String description, Pageable pageable);

    Rate findRateById(long id);

    void delete(long id, boolean isAdmin);

    Rate save(Rate rate, boolean isAdmin);

    Rate update(Rate rate, long id, boolean isAdmin);
}
