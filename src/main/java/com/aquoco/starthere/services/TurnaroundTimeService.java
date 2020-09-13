package com.aquoco.starthere.services;

import com.aquoco.starthere.models.TurnaroundTime;
import org.springframework.data.domain.Pageable;

import java.util.List;

/*
 * turnaroundtimes table fields: ttid, turnaroundtime
 */
public interface TurnaroundTimeService {

    List<TurnaroundTime> findAll(Pageable pageable);

    List<TurnaroundTime> findByTurnaroundtimeContaining(String turnaroundtime, Pageable pageable);

    TurnaroundTime findTurnaroundtimeById(long id);

    TurnaroundTime findByTurnaroundtime(String turnaroundtime);

    void delete(long id, boolean isAdmin);

    TurnaroundTime save(TurnaroundTime turnaroundtime, boolean isAdmin);

    TurnaroundTime update(TurnaroundTime turnaroundtime,
                         long id,
                         boolean isAdmin);

}
