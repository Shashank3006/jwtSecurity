package com.jwtSecurity.services.impl;

import com.jwtSecurity.dao.UserDao;
import com.jwtSecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao dao;

    public UserDetailServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       // Optional<User>= dao.findByUsername(username);
        return dao.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("User dose not Exits"));
    }
}
