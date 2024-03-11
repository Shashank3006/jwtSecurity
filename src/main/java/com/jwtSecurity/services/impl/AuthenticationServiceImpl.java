package com.jwtSecurity.services.impl;

import com.jwtSecurity.config.JwtService;
import com.jwtSecurity.dao.TokenRepository;
import com.jwtSecurity.dao.UserDao;
import com.jwtSecurity.dto.AuthenticationResponse;
import com.jwtSecurity.model.Token;
import com.jwtSecurity.model.User;
import com.jwtSecurity.services.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
private UserDao userDao;
private PasswordEncoder passwordEncoder;
private JwtService jwtService;
private TokenRepository dao;
private AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder, JwtService jwtService, TokenRepository dao, AuthenticationManager authenticationManager) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.dao = dao;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse regusterUserRequest(User request){
        //check is user alredy exits
        if(userDao.findByUsername(request.getUsername()).isPresent()){
            return  new AuthenticationResponse(null,"user already register");
        }
        User user=new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setRole(request.getRole());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        //request.setPassword(passwordEncoder.encode(request.getPassword()));
        User reg=userDao.save(user);
        String jwtToken=jwtService.generateToken(reg);
        //save to token TokenDB
        saveUserToken(jwtToken,reg);
        return new AuthenticationResponse(jwtToken,"user SuccessFully Register");
    }


    private void revokeAllToken(User user) {
        List<Token> tokens=dao.findAllTokenByUser(user.getId());
        if(tokens.isEmpty()){
            return;
        }
        tokens.forEach(t->t.setLoggedOut(true));
        dao.saveAll(tokens);
    }

    private void saveUserToken(String jwtToken, User user) {
        Token token=new Token();
        token.setToken(jwtToken);
        token.setLoggedOut(false);
        token.setUser(user);
        dao.save(token);
    }
    public AuthenticationResponse authenticate(User request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        User user=userDao.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.generateToken(user);
        revokeAllToken(user);
        saveUserToken(token,user);
        return  new AuthenticationResponse(token,"user login was successfull");
    }

}
