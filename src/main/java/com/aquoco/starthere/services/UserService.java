package com.aquoco.starthere.services;

import com.aquoco.starthere.models.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> findAll(Pageable pageable);

    List<User> findByNameContaining(String username, Pageable pageable);

    List<User> findByCompanyContainingIgnoreCase(String company, Pageable pageable);

    List<User> findByLastnameContainingIgnoreCase(String lastname, Pageable pageable);

    User findUserById(long id);

    User findByName(String name);

    List<User> findUsersByFactoring(boolean factoring, Pageable pageable);

    void delete(long id);

    User save(User user);

    User update(User user,
                long id,
                boolean isAdmin);

    User updateUserFactoring(long id,
                         boolean isAdmin);

    void deleteUserRole(long userid,
                        long roleid);

    void addUserRole(long userid,
                     long roleid);

}