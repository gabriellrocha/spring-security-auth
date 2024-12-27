package org.gabriel.spring_security_auth.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.gabriel.spring_security_auth.model.User;
import org.gabriel.spring_security_auth.model.UserDTO;
import org.gabriel.spring_security_auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    private List<Object> values = new ArrayList<>(); // gambiarra kk


    @GetMapping("/")
    public List<Object> greet(HttpServletRequest request){

        values.add(request.getSession().getId());
        values.add((CsrfToken)request.getAttribute("_csrf"));
        return values;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable long id) {

        Optional<UserDTO> user = userService.findById(id);

        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> createUser(@RequestBody User user){

        return ResponseEntity.ok(userService.createUser(user));

    }

}
