package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Customer;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<Customer> findAll(Pageable pageable);

    List<Customer> findByNameContaining(String username,
                                    Pageable pageable);

    List<Customer> getAllUsers(Pageable pageable);

    Customer findUserById(long id);

    Customer findByName(String name);

    void delete(long id);

    Customer save(Customer user);

    Customer update(Customer user,
                long id,
                boolean isAdmin);
/*
    void deleteUserRole(long userid,
                        long roleid);
    void addUserRole(long userid,
                     long roleid);
*/
}