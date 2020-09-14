package com.aquoco.starthere.repository;

import com.aquoco.starthere.models.ExamType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/*
 * examtypes table fields: eid, examination, ecode
 */
public interface ExamTypeRepository extends PagingAndSortingRepository<ExamType, Long> {

    ExamType findByExamination(String examination);

    List<ExamType> findByExaminationContainingIgnoreCase(String examination, Pageable pageable);

    ExamType findByEcode(String ecode);

    List<ExamType> findByEcodeContainingIgnoreCase(String ecode, Pageable pageable);

}
