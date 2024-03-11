package com.jwtSecurity.config;

import com.jwtSecurity.dao.TokenRepository;
import com.jwtSecurity.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {
    private final String SECRET_KEY="GYGUYUYUI7KKJHFF@3HHJG%5898HKHKD@";
    @Autowired
    private TokenRepository repository;
    public  JwtService(TokenRepository tokenRepository){
        this.repository= tokenRepository;
    }
    public String extractUserName(String token){
        return extractClams(token,Claims::getSubject);
    }
    private <T> T extractClams(String token, Function<Claims,T> resolver){
        Claims claims=extrAllClaims(token);
        return resolver.apply(claims);
    }
    private Claims extrAllClaims(String token){
        return Jwts
                .parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
     private SecretKey getSigningKey(){
        byte[] key= Decoders.BASE64URL.decode(SECRET_KEY);
         return Keys.hmacShaKeyFor(key);
     }
     public  boolean isValid(String token, UserDetails details){
        String userName=extractUserName(token);
       boolean isTokenValid= repository.findByToken(token)
               .map(t -> !t.isLoggedOut()).orElse(false);
       return (userName.equals(details.getUsername())&&isTokenValid &&isTokenExpired(token));



        }
        private  boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
        }
        private Date extractExpiration(String token){
        return extractClams(token,Claims::getExpiration);
        }
        public String generateToken(User user){
        String token=Jwts.builder().setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+24*60*60*10000))
                .signWith(getSigningKey())
                .compact();
//        //return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(userName)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
//                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();


           // String token= Jwts.builder().subject(user.getUsername()).issuedAt(new Date(System.currentTimeMillis())).expiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 10000))
               //     .signWith(getSigninKey())
                  //  .compact();
        return token;

        }
}
