package com.aquoco.starthere.services;

import com.aquoco.starthere.exceptions.ResourceNotFoundException;
import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.Case;
import com.aquoco.starthere.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/*
 * cases table fields:  casesid, party1, party1name, party2,
 * party2name, casenumber1, casenumber2, jurisdiction, notes
 */
@Loggable
@Service(value = "caseService")
public class CaseServiceImpl implements CaseService {

    @Autowired
    private CaseRepository caserepo;

    public Case findCaseById(long id) throws
            ResourceNotFoundException {
        return caserepo.findById(id)
                       .orElseThrow(() -> new ResourceNotFoundException("Case id " + id + " not found!"));

    }

    @Override
    public Case findByParty1(String party1) throws
            ResourceNotFoundException {

        if (caserepo.findByParty1(party1.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Party 1 " + party1 + " not found!");
        }
        return caserepo.findByParty1(party1.toLowerCase());

    }

    @Override
    public Case findByParty1name(String party1name) throws
            ResourceNotFoundException {
        if (caserepo.findByParty1name(party1name.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Party 1 name " + party1name + " not found!");
        }
        return caserepo.findByParty1name(party1name.toLowerCase());
    }

    @Override
    public Case findByParty2(String party2) throws
            ResourceNotFoundException {
        if (caserepo.findByParty2(party2.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Party 2 " + party2 + " not found!");
        }
        return caserepo.findByParty2(party2.toLowerCase());
    }

    @Override
    public Case findByParty2name(String party2name) throws
            ResourceNotFoundException {
        if (caserepo.findByParty2name(party2name.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Party 2 name " + party2name + " not found!");
        }
        return caserepo.findByParty2name(party2name.toLowerCase());
    }

    @Override
    public Case findByCasenumber1(String casenumber1) throws
            ResourceNotFoundException {
        if (caserepo.findByCasenumber1(casenumber1.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Case number 1 " + casenumber1 + " not found!");
        }
        return caserepo.findByCasenumber1(casenumber1.toLowerCase());
    }

    @Override
    public Case findByCasenumber2(String casenumber2) throws
            ResourceNotFoundException {
        if (caserepo.findByCasenumber2(casenumber2.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Case number 2 " + casenumber2 + " not found!");
        }
        return caserepo.findByCasenumber2(casenumber2.toLowerCase());
    }

    @Override
    public Case findByJurisdiction(String jurisdiction) throws
            ResourceNotFoundException {
        if (caserepo.findByJurisdiction(jurisdiction.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Case number 1 " + jurisdiction + " not found!");
        }
        return caserepo.findByJurisdiction(jurisdiction.toLowerCase());
    }

    @Override
    public List<Case> findAll(Pageable pageable) {
        List<Case> list = new ArrayList<>();
        caserepo.findAll(pageable)
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public List<Case> findByParty1Containing(String party1,
                                             Pageable pageable) {
        return caserepo.findByParty1ContainingIgnoreCase(party1.toLowerCase(),
                                                         pageable);

    }

    @Override
    public List<Case> findByParty1ContainingIgnoreCase(String party1,
                                                       Pageable pageable) {
        return caserepo.findByParty1ContainingIgnoreCase(party1.toLowerCase(),
                                                         pageable);
    }

    @Override
    public List<Case> findByParty1nameContaining(String party1name,
                                                 Pageable pageable) {
        return caserepo.findByParty1nameContainingIgnoreCase(party1name.toLowerCase(),
                                                             pageable);
    }

    @Override
    public List<Case> findByParty1nameContainingIgnoreCase(String party1name,
                                                           Pageable pageable) {
        return caserepo.findByParty1nameContainingIgnoreCase(party1name.toLowerCase(),
                                                             pageable);
    }

    @Override
    public List<Case> findByParty2Containing(String party2,
                                             Pageable pageable) {
        return caserepo.findByParty2ContainingIgnoreCase(party2.toLowerCase(),
                                                         pageable);
    }

    @Override
    public List<Case> findByParty2ContainingIgnoreCase(String party2,
                                                       Pageable pageable) {
        return caserepo.findByParty2ContainingIgnoreCase(party2.toLowerCase(),
                                                         pageable);
    }

    @Override
    public List<Case> findByParty2nameContaining(String party2name,
                                                 Pageable pageable) {
        return caserepo.findByParty2nameContainingIgnoreCase(party2name.toLowerCase(),
                                                             pageable);
    }

    @Override
    public List<Case> findByParty2nameContainingIgnoreCase(String party2name,
                                                           Pageable pageable) {
        return caserepo.findByParty2nameContainingIgnoreCase(party2name.toLowerCase(),
                                                             pageable);
    }

    @Override
    public List<Case> findByCasenumber1Containing(String casenumber1,
                                                  Pageable pageable) {
        return caserepo.findByCasenumber1ContainingIgnoreCase(casenumber1.toLowerCase(),
                                                              pageable);
    }

    @Override
    public List<Case> findByCasenumber1ContainingIgnoreCase(String casenumber1,
                                                            Pageable pageable) {
        return caserepo.findByCasenumber1ContainingIgnoreCase(casenumber1.toLowerCase(),
                                                              pageable);
    }

    @Override
    public List<Case> findByCasenumber2Containing(String casenumber2,
                                                  Pageable pageable) {
        return caserepo.findByCasenumber2ContainingIgnoreCase(casenumber2.toLowerCase(),
                                                              pageable);
    }

    @Override
    public List<Case> findByCasenumber2ContainingIgnoreCase(String casenumber2,
                                                            Pageable pageable) {
        return caserepo.findByCasenumber2ContainingIgnoreCase(casenumber2.toLowerCase(),
                                                              pageable);
    }

    @Override
    public List<Case> findByJurisdictionContaining(String jurisdiction,
                                                   Pageable pageable) {
        return caserepo.findByJurisdictionContainingIgnoreCase(jurisdiction.toLowerCase(),
                                                               pageable);
    }

    @Override
    public List<Case> findByJurisdictionContainingIgnoreCase(String jurisdiction,
                                                             Pageable pageable) {
        return caserepo.findByJurisdictionContainingIgnoreCase(jurisdiction.toLowerCase(),
                                                               pageable);
    }

    @Override
    public List<Case> findByNotesContaining(String notes,
                                            Pageable pageable) {
        return caserepo.findByNotesContainingIgnoreCase(notes.toLowerCase(),
                                                        pageable);
    }

    @Override
    public List<Case> findByNotesContainingIgnoreCase(String notes,
                                                      Pageable pageable) {
        return caserepo.findByNotesContainingIgnoreCase(notes.toLowerCase(),
                                                        pageable);
    }

    @Transactional
    @Override
    public void delete(long id) {

        caserepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("casesid " + id + " not found!"));
        caserepo.deleteById(id);
    }

    @Transactional
    @Override
    public Case save(Case singleCase) {

        Case newCase = new Case();

            /*
                if (caserepo.findByBrandingtheme(singleCase.getBrandingtheme()) != null) {
                    throw new ResourceFoundException(singleCase.getBrandingtheme() + " is already taken!");
                }
            */
        newCase.setParty1(singleCase.getParty1());
        newCase.setParty1name(singleCase.getParty1name());
        newCase.setParty2(singleCase.getParty2());
        newCase.setParty2name(singleCase.getParty2name());
        newCase.setCasenumber1(singleCase.getCasenumber1());
        newCase.setCasenumber2(singleCase.getCasenumber2());
        newCase.setJurisdiction(singleCase.getJurisdiction());
        newCase.setNotes(singleCase.getNotes());

        if (newCase.getParty1() != null) {
            newCase.setParty1(singleCase.getParty1());
        }

        if (newCase.getParty1name() != null) {
            newCase.setParty1name(singleCase.getParty1name());
        }
        if (newCase.getParty2() != null) {
            newCase.setParty2(singleCase.getParty2());
        }
        if (newCase.getParty2name() != null) {
            newCase.setParty2name(singleCase.getParty2name());
        }
        if (newCase.getCasenumber1() != null) {
            newCase.setCasenumber1(singleCase.getCasenumber1());
        }
        if (newCase.getCasenumber2() != null) {
            newCase.setCasenumber2(singleCase.getCasenumber2());
        }
        if (newCase.getJurisdiction() != null) {
            newCase.setJurisdiction(singleCase.getJurisdiction());
        }
        if (newCase.getNotes() != null) {
            newCase.setNotes(singleCase.getNotes());
        }

        return caserepo.save(newCase);

    }

    @Transactional
    @Override
    public Case update(Case singleCase,
                       long id) {

        Case currentCase = findCaseById(id);

        if (singleCase.getParty1() != null) {
            currentCase.setParty1(singleCase.getParty1());
        }
        if (singleCase.getParty1name() != null) {
            currentCase.setParty1name(singleCase.getParty1name());
        }
        if (singleCase.getParty2() != null) {
            currentCase.setParty2(singleCase.getParty2());
        }
        if (singleCase.getParty2name() != null) {
            currentCase.setParty2name(singleCase.getParty2name());
        }
        if (singleCase.getCasenumber1() != null) {
            currentCase.setCasenumber1(singleCase.getCasenumber1());
        }
        if (singleCase.getCasenumber2() != null) {
            currentCase.setCasenumber2(singleCase.getCasenumber2());
        }
        if (singleCase.getJurisdiction() != null) {
            currentCase.setJurisdiction(singleCase.getJurisdiction());
        }
        if (singleCase.getNotes() != null) {
            currentCase.setNotes(singleCase.getNotes());
        }

        return caserepo.save(currentCase);

    }
}