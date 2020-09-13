package com.aquoco.starthere.services;

import com.aquoco.starthere.exceptions.ResourceFoundException;
import com.aquoco.starthere.exceptions.ResourceNotFoundException;
import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.Rate;
import com.aquoco.starthere.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/*
    * rate table fields:  ratesid, code, inventoryratecode, productname, description, rate
 */
@Loggable
@Service(value = "rateService")
public class RateServiceImpl
            implements RateService {

    @Autowired
    private RateRepository raterepo;


    public Rate findRateById(long id) throws
            ResourceNotFoundException {
        return raterepo.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Rate id " + id + " not found!"));
    }

    @Override
    public Rate findByRate(Double rate) throws
            ResourceNotFoundException {

        if (raterepo.findByRate(rate) == null) {
            throw new ResourceNotFoundException(rate + " is not found!");

        }

        return raterepo.findByRate(rate);
    }

    @Transactional
    @Override
    public void delete(long id,
                       boolean isAdmin) {

        if (isAdmin) {
            raterepo.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Rate id " + id + " not found!"));
            raterepo.deleteById(id);
        }
    }

    @Transactional
    @Override
    public Rate save(Rate rate,
                     boolean isAdmin) {

        if (isAdmin) {

            if (raterepo.findByRate(rate.getRate()) != null) {
                throw new ResourceFoundException(rate.getRate() + " is already taken!");
            }

            Rate newRate = new Rate();
            newRate.setCode(rate.getCode().toUpperCase());
            newRate.setInventoryratecode(rate.getInventoryratecode());
            newRate.setProductname(rate.getProductname());
            newRate.setDescription(rate.getDescription());
            newRate.setRate(rate.getRate());

            if(rate.getCode() != null){
                newRate.setCode(rate.getCode());
            }
            if(rate.getInventoryratecode() != null){
                newRate.setInventoryratecode(rate.getInventoryratecode());
            }
            if(rate.getProductname() != null){
                newRate.setProductname(rate.getProductname());
            }
            if(rate.getDescription() != null){
                newRate.setDescription(rate.getDescription());
            }
            if(rate.getRate() != null){
                newRate.setRate(rate.getRate());
            }

            return raterepo.save(newRate);
        }

        return null;
    }

    @Override
    public List<Rate> findAll(Pageable pageable) {
        List<Rate> list = new ArrayList<>();
        raterepo.findAll(pageable)
                 .iterator()
                 .forEachRemaining(list::add);
        return list;
    }

    @Override
    public List<Rate> findByRateContaining(Double rate,
                                           Pageable pageable) {
        return raterepo.findByRateContaining(rate, pageable);
    }

    @Override
    public List<Rate> findByCodeContainingIgnoreCase(String code,
                                                        Pageable pageable) {
        return raterepo.findByCodeContainingIgnoreCase(code, pageable);
    }

    @Override
    public List<Rate> findByInventoryratecodeContainingIgnoreCase(String inventoryratecode,
                                                     Pageable pageable) {
        return raterepo.findByInventoryratecodeContainingIgnoreCase(inventoryratecode, pageable);
    }

    @Override
    public List<Rate> findByProductnameContainingIgnoreCase(String productname,
                                                     Pageable pageable) {
        return raterepo.findByProductnameContainingIgnoreCase(productname, pageable);
    }

    @Override
    public List<Rate> findByDescriptionContainingIgnoreCase(String description,
                                                     Pageable pageable) {
        return raterepo.findByDescriptionContainingIgnoreCase(description, pageable);
    }

    // Rate update(Rate rate, long id, boolean isAdmin);
    @Transactional
    @Override
    public Rate update(Rate rate,
                       long id,
                       boolean isAdmin) {

        if (isAdmin) {

            Rate currentRate = findRateById(id);

            if (rate.getCode() != null) {
                currentRate.setCode(rate.getCode());
            }

            if (rate.getInventoryratecode() != null) {
                currentRate.setInventoryratecode(rate.getInventoryratecode());
            }

            if (rate.getProductname() != null) {
                currentRate.setProductname(rate.getProductname());
            }

            if (rate.getDescription() != null) {
                currentRate.setDescription(rate.getDescription());
            }

            if (rate.getRate() != null) {
                currentRate.setRate(rate.getRate());
            }

            return raterepo.save(currentRate);

        } else {
            throw new ResourceNotFoundException(id + " Not current rate");
        }
    }

}
