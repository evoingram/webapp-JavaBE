package com.aquoco.starthere.repository;

import com.aquoco.starthere.models.Useremail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UseremailRepository
        extends CrudRepository<Useremail, Long> {
    List<Useremail> findAllByUser_Username(String name);
}
