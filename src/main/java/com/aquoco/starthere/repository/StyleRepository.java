package com.aquoco.starthere.repository;

import com.aquoco.starthere.models.Style;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StyleRepository
        extends PagingAndSortingRepository<Style, Long> {

    Style findByStylename(String stylename);

    List<Style> findByStylenameContainingIgnoreCase(String stylename, Pageable pageable);
    
}
