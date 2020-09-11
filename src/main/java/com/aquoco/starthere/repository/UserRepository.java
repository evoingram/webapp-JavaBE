package com.aquoco.starthere.repository;

import com.aquoco.starthere.models.User;
import com.aquoco.starthere.view.JustTheCount;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository
        extends PagingAndSortingRepository<User, Long> {

    User findByUsername(String username);

    List<User> findByUsernameContainingIgnoreCase(String name, Pageable pageable);

    @Query(value = "SELECT * FROM users WHERE factoring = :factoring",
            nativeQuery = true)
    List<User> findUsersByFactoring(boolean factoring, Pageable pageable);

    // SELECT * FROM Users WHERE Company LIKE 'a%';
    @Query(value = "SELECT * FROM users WHERE company LIKE ':searchPhrase" + "%'",
            nativeQuery = true)
    List<User> findUsersByCompany(String searchPhrase, Pageable pageable);
}
