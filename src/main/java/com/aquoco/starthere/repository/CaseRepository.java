package com.aquoco.starthere.repository;

import com.aquoco.starthere.models.Case;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CaseRepository
        extends PagingAndSortingRepository<Case, Long> {

    Case findByParty1(String party1);

    Case findByParty1name(String party1name);

    Case findByParty2(String party2);

    Case findByParty2name(String party2name);

    Case findByCasenumber1(String casenumber1);

    Case findByCasenumber2(String casenumber2);

    Case findByJurisdiction(String jurisdiction);

    List<Case> findByParty1ContainingIgnoreCase(String party1, Pageable pageable);

    List<Case> findByParty1nameContainingIgnoreCase(String party1name, Pageable pageable);

    List<Case> findByParty2ContainingIgnoreCase(String party2, Pageable pageable);

    List<Case> findByParty2nameContainingIgnoreCase(String party2name, Pageable pageable);

    List<Case> findByCasenumber1ContainingIgnoreCase(String casenumber1, Pageable pageable);

    List<Case> findByCasenumber2ContainingIgnoreCase(String casenumber2, Pageable pageable);

    List<Case> findByJurisdictionContainingIgnoreCase(String jurisdiction, Pageable pageable);

}
