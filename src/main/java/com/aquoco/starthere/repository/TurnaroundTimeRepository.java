package com.aquoco.starthere.repository;

import com.aquoco.starthere.models.TurnaroundTime;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/*
 * turnaroundtimes table fields: ttid, turnaroundtime
 */
public interface TurnaroundTimeRepository
        extends PagingAndSortingRepository<TurnaroundTime, Long> {

    TurnaroundTime findByTurnaroundtime(long turnaroundtime);

    List<TurnaroundTime> findByTurnaroundtimeContainingIgnoreCase(long turnaroundtime, Pageable pageable);

}
