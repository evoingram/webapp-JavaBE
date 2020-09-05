package com.aquoco.starthere.services;

import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.User;
import com.aquoco.starthere.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Loggable
@Service(value = "securityUserService")
public class SecurityUserServiceImpl
        implements UserDetailsService {

    @Autowired
    private UserRepository userrepos;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
        User user = userrepos.findByUsername(username.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername()
                                                                          .toLowerCase(),
                                                                      user.getPassword(),
                                                                      user.getAuthority());
    }
}
