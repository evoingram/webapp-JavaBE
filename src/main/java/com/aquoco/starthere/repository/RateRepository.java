package com.aquoco.starthere.repository;

import com.aquoco.starthere.models.Rate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/*
    * rate table fields:  ratesid, code, inventoryratecode, productname, description, rate
*/
public interface RateRepository
        extends PagingAndSortingRepository<Rate, Long> {

    Rate findByRate(Double rate);

    List<Rate> findByRateContainingIgnoreCase(Double rate, Pageable pageable);

    List<Rate> findByRateContaining(Double rate, Pageable pageable);

    List<Rate> findByCodeContainingIgnoreCase(String code, Pageable pageable);

    List<Rate> findByInventoryratecodeContainingIgnoreCase(String inventoryratecode, Pageable pageable);

    List<Rate> findByProductnameContainingIgnoreCase(String productname, Pageable pageable);

    List<Rate> findByDescriptionContainingIgnoreCase(String description, Pageable pageable);

}
