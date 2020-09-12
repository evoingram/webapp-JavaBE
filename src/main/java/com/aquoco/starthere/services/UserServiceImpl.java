package com.aquoco.starthere.services;

import com.aquoco.starthere.exceptions.ResourceFoundException;
import com.aquoco.starthere.exceptions.ResourceNotFoundException;
import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.Role;
import com.aquoco.starthere.models.User;
import com.aquoco.starthere.models.UserRoles;
import com.aquoco.starthere.models.Useremail;
import com.aquoco.starthere.repository.RoleRepository;
import com.aquoco.starthere.repository.UserRepository;
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
public class UserServiceImpl
        implements UserService {

    @Autowired
    private UserRepository userrepos;

    @Autowired
    private RoleRepository rolerepos;

    public User findUserById(long id) throws
            ResourceNotFoundException {
        return userrepos.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("User id " + id + " not found!"));
    }

    @Override
    public List<User> findByNameContaining(String username,
                                           Pageable pageable) {
        return userrepos.findByUsernameContainingIgnoreCase(username.toLowerCase(),
                                                            pageable);
    }

    @Override
    public List<User> findAll(Pageable pageable) {
        List<User> list = new ArrayList<>();
        userrepos.findAll(pageable)
                 .iterator()
                 .forEachRemaining(list::add);
        return list;
    }

    @Override
    public List<User> findUsersByFactoring(boolean factoring,
                                           Pageable pageable) {
        return userrepos.findUsersByFactoring(factoring, pageable);
    }

    @Override
    public List<User> findByCompanyContainingIgnoreCase(String company,
                                           Pageable pageable) {
        return userrepos.findByCompanyContainingIgnoreCase(company, pageable);
    }

    @Override
    public List<User> findByLastnameContainingIgnoreCase(String lastname,
                                                        Pageable pageable) {
        return userrepos.findByLastnameContainingIgnoreCase(lastname, pageable);
    }

    @Override
    public List<User> findByFirstnameContainingIgnoreCase(String firstname,
                                                         Pageable pageable) {
        return userrepos.findByFirstnameContainingIgnoreCase(firstname, pageable);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userrepos.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("User id " + id + " not found!"));
        userrepos.deleteById(id);
    }

    @Override
    public User findByName(String name) {
        User uu = userrepos.findByUsername(name.toLowerCase());
        if (uu == null) {
            throw new ResourceNotFoundException("User name " + name + " not found!");
        }
        return uu;
    }

    @Transactional
    @Override
    public User save(User user) {
        if (userrepos.findByUsername(user.getUsername().toLowerCase()) != null) {
            throw new ResourceFoundException(user.getUsername() + " is already taken!");
        }

        User newUser = new User();
        newUser.setUsername(user.getUsername().toLowerCase());
        newUser.setPasswordNoEncrypt(user.getPassword());
        newUser.setPrimaryemail(user.getPrimaryemail()
                                    .toLowerCase());
        newUser.setFactoring(false);
        newUser.setLastname(user.getLastname());
        newUser.setFirstname(user.getFirstname());
        newUser.setAddress1(user.getAddress1());
        newUser.setCity(user.getCity());
        newUser.setState(user.getState());
        newUser.setPostalcode(user.getPostalcode());

        if(user.getCompany() != null){
            newUser.setCompany(user.getCompany());
        }
        if(user.getMrms() != null){
            newUser.setMrms(user.getMrms());
        }
        if(user.getJobtitle() != null){
            newUser.setJobtitle(user.getJobtitle());
        }
        if(user.getBusinessphone() != null){
            newUser.setBusinessphone(user.getBusinessphone());
        }
        if(user.getAddress2() != null){
            newUser.setAddress2(user.getAddress2());
        }
        if(user.getNotes() != null){
            newUser.setNotes(user.getNotes());
        }

        ArrayList<UserRoles> newRoles = new ArrayList<>();
        for (UserRoles ur : user.getUserroles()) {
            long id = ur.getRole()
                        .getRoleid();
            Role role = rolerepos.findById(id)
                                 .orElseThrow(() -> new ResourceNotFoundException("Role id " + id + " not found!"));
            newRoles.add(new UserRoles(newUser,
                                       ur.getRole()));
        }
        newUser.setUserroles(newRoles);

        for (Useremail ue : user.getUseremails()) {
            newUser.getUseremails()
                   .add(new Useremail(newUser,
                                      ue.getUseremail()));
        }

        return userrepos.save(newUser);
    }

    @Transactional
    @Override
    public User update(User user,
                       long id,
                       boolean isAdmin) {
        Authentication authentication = SecurityContextHolder.getContext()
                                                             .getAuthentication();

        User authenticatedUser = userrepos.findByUsername(authentication.getName());

        if (id == authenticatedUser.getUserid() || isAdmin) {
            User currentUser = findUserById(id);

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

            if (user.getLastname() != null) {
                currentUser.setLastname(user.getLastname());
            }

            if (user.getFirstname() != null) {
                currentUser.setFirstname(user.getFirstname());
            }

            if (user.getAddress1() != null) {
                currentUser.setAddress1(user.getAddress1());
            }

            if (user.getCity() != null) {
                currentUser.setCity(user.getCity());
            }

            if (user.getState() != null) {
                currentUser.setState(user.getState());
            }

            if (user.getPostalcode() != null) {
                currentUser.setPostalcode(user.getPostalcode());
            }

            if(user.getCompany() != null) {
                currentUser.setCompany(user.getCompany());
            }

            if(user.getMrms() != null) {
                currentUser.setMrms(user.getMrms());
            }

            if(user.getJobtitle() != null) {
                currentUser.setJobtitle(user.getJobtitle());
            }

            if(user.getBusinessphone() != null) {
                currentUser.setBusinessphone(user.getBusinessphone());
            }

            if(user.getAddress2() != null) {
                currentUser.setAddress2(user.getAddress2());
            }

            if(user.getNotes() != null) {
                currentUser.setNotes(user.getNotes());
            }

            if (user.getUserroles()
                    .size() > 0) {
                throw new ResourceFoundException("User Roles are not updated through User. See endpoint POST: users/user/{userid}/role/{roleid}");
            }

            if (user.getUseremails()
                    .size() > 0) {
                for (Useremail ue : user.getUseremails()) {
                    currentUser.getUseremails()
                               .add(new Useremail(currentUser,
                                                  ue.getUseremail()));
                }
            }

            return userrepos.save(currentUser);
        } else {
            throw new ResourceNotFoundException(id + " Not current user");
        }
    }

    @Transactional
    @Override
    public User updateUserFactoring(long id, boolean isAdmin) {

        if (isAdmin) {

            User currentUser = findUserById(id);

            currentUser.setFactoring(!currentUser.isFactoring());

            return userrepos.save(currentUser);

        } else {

            throw new ResourceNotFoundException(id + " Not current user");

        }

    }

    @Transactional
    @Override
    public void deleteUserRole(long userid, long roleid) {
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
}
