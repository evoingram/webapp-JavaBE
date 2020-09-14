package com.aquoco.starthere.services;

import com.aquoco.starthere.exceptions.ResourceFoundException;
import com.aquoco.starthere.exceptions.ResourceNotFoundException;
import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.ExamType;
import com.aquoco.starthere.repository.ExamTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/*
 * examtypes table fields: eid, examination, ecode
 */
@Loggable
@Service(value = "examtypeService")
public class ExamTypeServiceImpl implements ExamTypeService {

    @Autowired
    private ExamTypeRepository examtyperepo;

    @Override
    public List<ExamType> findAll(Pageable pageable) {
        List<ExamType> list = new ArrayList<>();
        examtyperepo.findAll(pageable)
                 .iterator()
                 .forEachRemaining(list::add);
        return list;
    }

    public ExamType findExamtypeById(long id) throws
            ResourceNotFoundException {
        return examtyperepo.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("ExamType ID " + id + " not found!"));
    }

    @Override
    public ExamType findByExamination(String examination) {

        if (examtyperepo.findByExamination(examination.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Examination " + examination + " not found!");
        }
        return examtyperepo.findByExamination(examination.toLowerCase());

    }

    @Override
    public List<ExamType> findByExaminationContainingIgnoreCase(String examination,
                                                           Pageable pageable) {
        return examtyperepo.findByExaminationContainingIgnoreCase(examination,
                                                             pageable);
    }

    @Override
    public ExamType findByEcode(String ecode) {

        if (examtyperepo.findByEcode(ecode.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Ecode " + ecode + " not found!");
        }
        return examtyperepo.findByEcode(ecode.toLowerCase());

    }

    @Override
    public List<ExamType> findByEcodeContainingIgnoreCase(String ecode,
                                                           Pageable pageable) {
        return examtyperepo.findByEcodeContainingIgnoreCase(ecode,
                                                             pageable);
    }


    @Transactional
    @Override
    public void delete(long id, boolean isAdmin) {

        if (isAdmin) {
            examtyperepo.findById(id)
                     .orElseThrow(() -> new ResourceNotFoundException("eid " + id + " not found!"));
            examtyperepo.deleteById(id);
        }
    }

    @Transactional
    @Override
    public ExamType save(ExamType examType, boolean isAdmin) {

        if (isAdmin) {

            if (examtyperepo.findByExamination(examType.getExamination()) != null) {
                throw new ResourceFoundException(examType.getExamination() + " is already taken!");
            }

            ExamType newExamType = new ExamType();
            newExamType.setExamination(examType.getExamination());

            if (newExamType.getExamination() != null) {
                newExamType.setExamination(examType.getExamination());
            }

            newExamType.setEcode(examType.getEcode());

            if (newExamType.getEcode() != null) {
                newExamType.setEcode(examType.getEcode());
            }

            return examtyperepo.save(newExamType);
        }

        return null;
    }

    @Transactional
    @Override
    public ExamType update(ExamType examType,
                        long id,
                        boolean isAdmin) {

        if (isAdmin) {

            ExamType currentExamType = findExamtypeById(id);

            if(examType.getExamination() != null) {
                currentExamType.setExamination(examType.getExamination());
            }

            if(examType.getEcode() != null) {
                currentExamType.setExamination(examType.getEcode());
            }

            return examtyperepo.save(currentExamType);

        } else {
            throw new ResourceNotFoundException(id + " not current examtype");
        }


    }
}
