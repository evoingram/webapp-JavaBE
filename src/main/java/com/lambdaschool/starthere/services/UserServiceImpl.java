package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.exceptions.ResourceFoundException;
import com.lambdaschool.starthere.exceptions.ResourceNotFoundException;
import com.lambdaschool.starthere.logging.Loggable;
import com.lambdaschool.starthere.models.Customer;
import com.lambdaschool.starthere.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Loggable
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userrepos;

    public Customer findUserById(long id) throws
            ResourceNotFoundException {
        return userrepos.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("User id " + id + " not found!"));
    }

    @Override
    public List<Customer> findByNameContaining(String username,
                                           Pageable pageable) {
        return userrepos.findByUsernameContainingIgnoreCase(username.toLowerCase(),
                                                            pageable);
    }

    @Transactional
    @Override
    public List<Customer> getAllUsers(Pageable pageable) {
        return userrepos.getAllUsers(pageable);
    }

    @Override
    public List<Customer> findAll(Pageable pageable) {
        List<Customer> list = new ArrayList<>();
        userrepos.findAll(pageable)
                 .iterator()
                 .forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public void delete(long id) {
        userrepos.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("User id " + id + " not found!"));
        userrepos.deleteById(id);
    }

    @Override
    public Customer findByName(String name) {
        Customer uu = userrepos.findByUsername(name.toLowerCase());
        if (uu == null) {
            throw new ResourceNotFoundException("User name " + name + " not found!");
        }
        return uu;
    }

    @Transactional
    @Override
    public Customer save(Customer user) {
        if (userrepos.findByUsername(user.getUsername()
                                         .toLowerCase()) != null) {
            throw new ResourceFoundException(user.getUsername() + " is already taken!");
        }

        Customer newUser = new Customer();
        newUser.setUsername(user.getUsername()
                                .toLowerCase());
        newUser.setPasswordNoEncrypt(user.getPassword());
        newUser.setPrimaryemail(user.getPrimaryemail()
                                    .toLowerCase());

        return userrepos.save(newUser);
    }

    @Transactional
    @Override
    public Customer update(Customer user,
                       long id,
                       boolean isAdmin) {
        Authentication authentication = SecurityContextHolder.getContext()
                                                             .getAuthentication();

        Customer authenticatedUser = userrepos.findByUsername(authentication.getName());

        if (id == authenticatedUser.getCustomersid() || isAdmin) {
            Customer currentUser = findUserById(id);

            if (user.getUsername() != null) {
                currentUser.setUsername(user.getUsername()
                                            .toLowerCase());
            }

            if (user.getPassword() != null) {
                currentUser.setPasswordNoEncrypt(user.getPassword());
            }

            if (user.getPrimaryemail() != null) {
                currentUser.setPrimaryemail(user.getPrimaryemail()
                                                .toLowerCase());
            }
/*
            if (user.getUsertypes()
                    .size() > 0) {
                throw new ResourceFoundException("User Roles are not updated through User. See endpoint POST: users/user/{userid}/role/{roleid}");
            }
*/
            return userrepos.save(currentUser);
        } else {
            throw new ResourceNotFoundException(id + " Not current user");
        }
    }
/*
    @Transactional
    @Override
    public void deleteUserRole(long userid,
                               long roleid) {
        userrepos.findById(userid)
                 .orElseThrow(() -> new ResourceNotFoundException("User id " + userid + " not found!"));
        rolerepos.findById(roleid)
                 .orElseThrow(() -> new ResourceNotFoundException("Role id " + roleid + " not found!"));

        if (rolerepos.checkUserRolesCombo(userid,
                                          roleid)
                     .getCount() > 0) {
            rolerepos.deleteUserRoles(userid,
                                      roleid);
        } else {
            throw new ResourceNotFoundException("Role and User Combination Does Not Exists");
        }
    }
    @Transactional
    @Override
    public void addUserRole(long userid,
                            long roleid) {
        userrepos.findById(userid)
                 .orElseThrow(() -> new ResourceNotFoundException("User id " + userid + " not found!"));
        rolerepos.findById(roleid)
                 .orElseThrow(() -> new ResourceNotFoundException("Role id " + roleid + " not found!"));

        if (rolerepos.checkUserRolesCombo(userid,
                                          roleid)
                     .getCount() <= 0) {
            rolerepos.insertUserRoles(userid,
                                      roleid);
        } else {
            throw new ResourceFoundException("Role and User Combination Already Exists");
        }
    }
*/
}
