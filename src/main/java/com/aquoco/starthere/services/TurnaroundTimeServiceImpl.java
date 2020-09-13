package com.aquoco.starthere.services;

import com.aquoco.starthere.exceptions.ResourceFoundException;
import com.aquoco.starthere.exceptions.ResourceNotFoundException;
import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.TurnaroundTime;
import com.aquoco.starthere.repository.TurnaroundTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/*
 * turnaroundtimes table fields: ttid, turnaroundtime
 */
@Loggable
@Service(value = "turnaroundtimeService")
public class TurnaroundTimeServiceImpl implements TurnaroundTimeService  {

    @Autowired
    private TurnaroundTimeRepository ttrepo;


    public TurnaroundTime findTurnaroundtimeById(long id) throws
            ResourceNotFoundException {
        return ttrepo.findById(id)
                     .orElseThrow(() -> new ResourceNotFoundException("Turnaround Time ID " + id + " not found!"));
    }

    @Override
    public TurnaroundTime findByTurnaroundtime(String turnaroundtime) {
        return null;
    }

    @Override
    public List<TurnaroundTime> findByTurnaroundtimeContaining(String turnaroundtime,
                                                             Pageable pageable) {
        return ttrepo.findByTurnaroundtimeContainingIgnoreCase(turnaroundtime,
                                                              pageable);
    }

    @Override
    public List<TurnaroundTime> findAll(Pageable pageable) {
        List<TurnaroundTime> list = new ArrayList<>();
        ttrepo.findAll(pageable)
              .iterator()
              .forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public void delete(long id, boolean isAdmin) {

        if (isAdmin) {
            ttrepo.findById(id)
                  .orElseThrow(() -> new ResourceNotFoundException("ttid " + id + " not found!"));
            ttrepo.deleteById(id);
        }
    }

    @Transactional
    @Override
    public TurnaroundTime save(TurnaroundTime turnaroundtime, boolean isAdmin) {

        if (isAdmin) {

            if (ttrepo.findByTurnaroundtime(Integer.toString(turnaroundtime.getTurnaroundtime())) != null) {
                throw new ResourceFoundException(turnaroundtime.getTurnaroundtime() + " is already taken!");
            }

            TurnaroundTime newTT = new TurnaroundTime();
            newTT.setTurnaroundtime(turnaroundtime.getTurnaroundtime());

            return ttrepo.save(newTT);
        }

        return null;
    }

    @Transactional
    @Override
    public TurnaroundTime update(TurnaroundTime turnaroundtime,
                                long id,
                                boolean isAdmin) {

        if (isAdmin) {

            TurnaroundTime currentTT = findTurnaroundtimeById(id);

            currentTT.setTurnaroundtime(turnaroundtime.getTurnaroundtime());

            return ttrepo.save(currentTT);

        } else {
            throw new ResourceNotFoundException(id + " not current turnaround time");
        }


    }
}
