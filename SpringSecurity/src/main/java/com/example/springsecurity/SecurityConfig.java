package com.example.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user= User.builder()
//                .username("user")
////                .password("{noop}ourpassword")
////                .password("{bcrypt}$2a$12$8/We6MLGayJGYua2r1GoN.CE8JZIkZcP5dIfXNugWay9oElmeMJqu")
//                .password("$2a$12$8/We6MLGayJGYua2r1GoN.CE8JZIkZcP5dIfXNugWay9oElmeMJqu")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/login", "/register").permitAll()
                    .anyRequest().authenticated()
            )
            .formLogin(form -> {});

    return http.build();
}
}
