package org.gabriel.spring_security_auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        UserDetails userImpl = User
//                .withUsername("gabriel")
//                .password("{noop}senha")
//                .build();
//
//        return new InMemoryUserDetailsManager(userImpl);
//    }

    @Bean
    public AuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider daoProviderImpl = new DaoAuthenticationProvider();
        daoProviderImpl.setUserDetailsService(userDetailsService);
        daoProviderImpl.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        return daoProviderImpl;
    }
}
