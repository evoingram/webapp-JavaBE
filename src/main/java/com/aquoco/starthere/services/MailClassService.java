package com.aquoco.starthere.services;

import com.aquoco.starthere.models.MailClass;
import org.springframework.data.domain.Pageable;

import java.util.List;

/*
 * mailclass table fields: mcid, mailclass, description
 */
public interface MailClassService {

    List<MailClass> findAll(Pageable pageable);

    List<MailClass> findByMailclassContainingIgnoreCase(String mailclass, Pageable pageable);

    List<MailClass> findByDescriptionContainingIgnoreCase(String description, Pageable pageable);

    MailClass findMailclassById(long id);

    MailClass findByMailclass(String mailclass);

    void delete(long id, boolean isAdmin);

    MailClass save(MailClass mailclass, boolean isAdmin);

    MailClass update(MailClass mailclass, long id, boolean isAdmin);

}
