package com.aquoco.starthere.services;

import com.aquoco.starthere.models.Style;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StyleService {

    List<Style> findAll(Pageable pageable);

    Style findStyleById(long id);

    Style findByStylename(String stylename);

    List<Style> findByStylenameContaining(String stylename, Pageable pageable);

    void delete(long id, boolean isAdmin);

    Style save(Style stylename, boolean isAdmin);

    Style update(Style stylename,
                         long id,
                         boolean isAdmin);

}
