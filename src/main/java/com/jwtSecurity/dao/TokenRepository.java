package com.jwtSecurity.dao;

import com.jwtSecurity.model.Token;
import com.jwtSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {


    Optional<Token> findByToken(String token);
    @Query(
            nativeQuery = true,
            value
                    = "SELECT t From Token t join User u on t.id = u.id where t.id= :userId and t.loggedOut = false")
    List<Token> findAllTokenByUser(Long userId );
}
