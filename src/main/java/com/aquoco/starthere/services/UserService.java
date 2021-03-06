package com.aquoco.starthere.services;

import com.aquoco.starthere.models.User;
import org.springframework.data.domain.Pageable;

import java.util.List;
/*
    * user table fields:  userid, address1, address2, businessphone, city,
    * company, creditApproved,firstname, jobtitle, lastname, mrms, notes,
    * password, postalcode, primaryemail, state, username
 */
public interface UserService {

    List<User> findAll(Pageable pageable);

    List<User> findByNameContaining(String username, Pageable pageable);

    List<User> findByCompanyContainingIgnoreCase(String company, Pageable pageable);

    List<User> findByLastnameContainingIgnoreCase(String lastname, Pageable pageable);

    List<User> findByFirstnameContainingIgnoreCase(String firstname, Pageable pageable);

    List<User> findByBusinessphoneContainingIgnoreCase(String businessphone, Pageable pageable);

    List<User> findByAddress1ContainingIgnoreCase(String address1, Pageable pageable);

    List<User> findByCityContainingIgnoreCase(String city, Pageable pageable);

    List<User> findByStateContainingIgnoreCase(String state, Pageable pageable);

    List<User> findByPostalcodeContainingIgnoreCase(String postalcode, Pageable pageable);

    List<User> findByNotesContainingIgnoreCase(String notes, Pageable pageable);

    User findUserById(long id);

    User findByName(String name);

    List<User> findUsersByCreditApproved(boolean creditApproved, Pageable pageable);

    void delete(long id);

    User save(User user);

    User update(User user,
                long id,
                boolean isAdmin);

    User updateUserCreditApproved(long id,
                         boolean isAdmin);

    void deleteUserRole(long userid,
                        long roleid);

    void addUserRole(long userid,
                     long roleid);

}