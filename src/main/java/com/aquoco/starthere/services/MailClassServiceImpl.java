package com.aquoco.starthere.services;

import com.aquoco.starthere.exceptions.ResourceFoundException;
import com.aquoco.starthere.exceptions.ResourceNotFoundException;
import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.MailClass;
import com.aquoco.starthere.repository.MailClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/*
 * mailclass table fields: mcid, mailclass, description
 */
@Loggable
@Service(value = "mailclassService")
public class MailClassServiceImpl implements MailClassService {

    @Autowired
    private MailClassRepository mcrepo;


    public MailClass findMailclassById(long id) throws
            ResourceNotFoundException {
        return mcrepo.findById(id)
                     .orElseThrow(() -> new ResourceNotFoundException("Mail Class ID " + id + " not found!"));
    }

    @Override
    public MailClass findByMailclass(String mailclass) {
        return null;
    }

    @Override
    public List<MailClass> findByMailclassContainingIgnoreCase(String mailclass,
                                                             Pageable pageable) {
        return mcrepo.findByMailclassContainingIgnoreCase(mailclass, pageable);
    }

    @Override
    public List<MailClass> findByDescriptionContainingIgnoreCase(String description,
                                                               Pageable pageable) {
        return mcrepo.findByDescriptionContainingIgnoreCase(description, pageable);
    }


    @Override
    public List<MailClass> findAll(Pageable pageable) {
        List<MailClass> list = new ArrayList<>();
        mcrepo.findAll(pageable)
              .iterator()
              .forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public void delete(long id, boolean isAdmin) {

        if (isAdmin) {
            mcrepo.findById(id)
                  .orElseThrow(() -> new ResourceNotFoundException("mcid " + id + " not found!"));
            mcrepo.deleteById(id);
        }
    }

    @Transactional
    @Override
    public MailClass save(MailClass mailClass, boolean isAdmin) {

        if (isAdmin) {

            if (mcrepo.findByMailclass(mailClass.getMailclass()) != null) {
                throw new ResourceFoundException(mailClass.getMailclass() + " is already taken!");
            }

            MailClass newMC = new MailClass();
            newMC.setMailclass(mailClass.getMailclass());
            newMC.setDescription(mailClass.getDescription());

            if (newMC.getMailclass() != null) {
                newMC.setDescription(mailClass.getMailclass());
            }

            if (newMC.getDescription() != null) {
                newMC.setDescription(mailClass.getDescription());
            }

            return mcrepo.save(newMC);
        }

        return null;
    }

    @Transactional
    @Override
    public MailClass update(MailClass mailClass,
                                long id,
                                boolean isAdmin) {

        if (isAdmin) {

            MailClass currentMC = findMailclassById(id);


            if(mailClass.getMailclass() != null) {
                currentMC.setMailclass(mailClass.getMailclass());
            }

            if(mailClass.getDescription() != null) {
                currentMC.setDescription(mailClass.getDescription());
            }

            return mcrepo.save(currentMC);

        } else {
            throw new ResourceNotFoundException(id + " not current mail class");
        }


    }
}
