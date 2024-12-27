package org.gabriel.spring_security_auth.service;

import org.gabriel.spring_security_auth.model.User;
import org.gabriel.spring_security_auth.model.UserDTO;
import org.gabriel.spring_security_auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserDTO createUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword())); // BCrypt

        return new UserDTO(userRepository.save(user));
    }

    public Optional<UserDTO> findById(long id) {

        return userRepository.findById(id)
                .map(UserDTO::new);
    }

}
