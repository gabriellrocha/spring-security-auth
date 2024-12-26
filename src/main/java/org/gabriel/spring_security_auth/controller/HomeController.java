package org.gabriel.spring_security_auth.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    private List<Object> values = new ArrayList<>(); // gambiarra kk


    @GetMapping("/")
    public List<Object> greet(HttpServletRequest request){

        values.add(request.getSession().getId());
        values.add((CsrfToken)request.getAttribute("_csrf"));
        return values;
    }

    @PostMapping("/")
    public String methPost(){
        return "Success";
    }

}
