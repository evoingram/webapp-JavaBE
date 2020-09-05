package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Customer;
import com.lambdaschool.starthere.view.JustTheCount;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository
        extends PagingAndSortingRepository<Customer, Long> {
    Customer findByUsername(String username);

    List<Customer> findByUsernameContainingIgnoreCase(String name,
                                                  Pageable pageable);

    @Query(value = "SELECT * FROM Customers",
            nativeQuery = true)
    List<Customer> getAllUsers(Pageable pageable);

}
