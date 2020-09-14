package com.aquoco.starthere.services;

import com.aquoco.starthere.models.ExamType;
import org.springframework.data.domain.Pageable;

import java.util.List;

/*
 * examtypes table fields: eid, examination, ecode
 */
public interface ExamTypeService {

    List<ExamType> findAll(Pageable pageable);

    ExamType findExamtypeById(long id);

    ExamType findByExamination(String examination);

    List<ExamType> findByExaminationContainingIgnoreCase(String examination, Pageable pageable);

    ExamType findByEcode(String ecode);

    List<ExamType> findByEcodeContainingIgnoreCase(String ecode, Pageable pageable);

    void delete(long id, boolean isAdmin);

    ExamType save(ExamType examtype, boolean isAdmin);

    ExamType update(ExamType examtype,
                 long id,
                 boolean isAdmin);

}
