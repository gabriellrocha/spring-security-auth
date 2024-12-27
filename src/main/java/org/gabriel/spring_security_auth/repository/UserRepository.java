package org.gabriel.spring_security_auth.repository;

import org.gabriel.spring_security_auth.model.CustomUserDetails;
import org.gabriel.spring_security_auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {


    User findByUsername(String username);

}
