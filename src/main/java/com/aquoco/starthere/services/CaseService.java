package com.aquoco.starthere.services;

import com.aquoco.starthere.models.Case;
import org.springframework.data.domain.Pageable;

import java.util.List;

/*
    * cases table fields:  casesid, party1, party1name, party2,
    * party2name, casenumber1, casenumber2, jurisdiction, notes
 */
public interface CaseService {

    List<Case> findAll(Pageable pageable);

    List<Case> findByParty1Containing(String party1, Pageable pageable);

    List<Case> findByParty1nameContaining(String party1name, Pageable pageable);

    List<Case> findByParty2Containing(String party2, Pageable pageable);

    List<Case> findByParty2nameContaining(String party2name, Pageable pageable);

    List<Case> findByCasenumber1Containing(String casenumber1, Pageable pageable);

    List<Case> findByCasenumber2Containing(String casenumber2, Pageable pageable);

    List<Case> findByJurisdictionContaining(String jurisdiction, Pageable pageable);

    List<Case> findByNotesContaining(String notes, Pageable pageable);

    List<Case> findByParty1ContainingIgnoreCase(String party1, Pageable pageable);

    List<Case> findByParty1nameContainingIgnoreCase(String party1name, Pageable pageable);

    List<Case> findByParty2ContainingIgnoreCase(String party2, Pageable pageable);

    List<Case> findByParty2nameContainingIgnoreCase(String party2name, Pageable pageable);

    List<Case> findByCasenumber1ContainingIgnoreCase(String casenumber1, Pageable pageable);

    List<Case> findByCasenumber2ContainingIgnoreCase(String casenumber2, Pageable pageable);

    List<Case> findByJurisdictionContainingIgnoreCase(String jurisdiction, Pageable pageable);

    List<Case> findByNotesContainingIgnoreCase(String notes, Pageable pageable);

    Case findCaseById(long id);

    Case findByParty1(String party1);

    Case findByParty1name(String party1name);

    Case findByParty2(String party2);

    Case findByParty2name(String party2name);

    Case findByCasenumber1(String casenumber1);

    Case findByCasenumber2(String casenumber2);

    Case findByJurisdiction(String jurisdiction);

    void delete(long id);

    Case save(Case singlecase);

    Case update(Case singlecase,
                long id,
                boolean isAdmin);
}
