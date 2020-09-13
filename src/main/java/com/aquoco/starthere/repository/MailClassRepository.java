package com.aquoco.starthere.repository;

import com.aquoco.starthere.models.MailClass;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/*
 * mailclass table fields: mcid, mailclass, description
 */
public interface MailClassRepository
        extends PagingAndSortingRepository<MailClass, Long> {

    MailClass findByMailclass(String mailclass);

    MailClass findByDescription(String description);

    List<MailClass> findByMailclassContainingIgnoreCase(String mailclass, Pageable pageable);

    List<MailClass> findByDescriptionContainingIgnoreCase(String description, Pageable pageable);
}
