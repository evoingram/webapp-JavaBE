package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.User;
import com.lambdaschool.starthere.view.JustTheCount;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository
        extends PagingAndSortingRepository<User, Long> {
    User findByUsername(String username);

    List<User> findByUsernameContainingIgnoreCase(String name,
                                                  Pageable pageable);

    @Query(value = "SELECT * FROM Customers",
            nativeQuery = true)
    List<User> getAllUsers(Pageable pageable);

}
