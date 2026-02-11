package com.example.demo.config;

import com.example.demo.filters.JwtAuthFilter;
import com.example.demo.service.impl.security.AdminDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 🔐 Encoder (shared)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // ================= ADMIN =================
    @Bean
    @Order(1)
    SecurityFilterChain adminSecurity(
            HttpSecurity http,
            @Qualifier("adminDetailsService")
            AdminDetailsService adminDetailsService
    ) throws Exception {

        DaoAuthenticationProvider adminProvider = new DaoAuthenticationProvider();
        adminProvider.setUserDetailsService(adminDetailsService);
        adminProvider.setPasswordEncoder(passwordEncoder());

        http
                .securityMatcher("/admin/**")
                .authenticationProvider(adminProvider)
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/admin/login",
                                "/admin/process-login",
                                "/css/**",
                                "/images/**"
                        ).permitAll()
                        .anyRequest().hasAuthority("ADMIN")
                )
                .formLogin(form -> form
                        .loginPage("/admin/login")
                        .loginProcessingUrl("/admin/process-login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/admin/dashboard", true)
                        .failureUrl("/admin/login?error=true")
                )
                .logout(logout -> logout
                        .logoutUrl("/admin/logout")
                        .logoutSuccessUrl("/admin/login?logout=true")
                );

        return http.build();
    }
    @Bean
    public DaoAuthenticationProvider customerAuthenticationProvider(
            @Qualifier("customUserDetailServiceImpl")
            UserDetailsService customerDetailsService,
            PasswordEncoder passwordEncoder
    ) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customerDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }


    // ================= CUSTOMER AUTH MANAGER =================
    @Bean(name = "customerAuthenticationManager")
    public AuthenticationManager customerAuthenticationManager(
            DaoAuthenticationProvider customerAuthenticationProvider
    ) {
        return new ProviderManager(customerAuthenticationProvider);
    }
    // ================= CUSTOMER =================
//    @Bean
//    @Order(3)
//    SecurityFilterChain customerSecurity(
//            HttpSecurity http,
//            DaoAuthenticationProvider customerAuthenticationProvider
//    ) throws Exception {
//
//        http
//                .securityMatcher("/customers/**")
//                .authenticationProvider(customerAuthenticationProvider)
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(
//                                "/customers/login",
//                                "/customers/signup",
//                                "/customers/process-login",
//                                "/css/**",
//                                "/images/**"
//                        ).permitAll()
//                        .anyRequest().hasRole("CUSTOMER")
//                )
//                .formLogin(form -> form
//                        .loginPage("/customers/login")
//                        .loginProcessingUrl("/customers/process-login")
//                        .defaultSuccessUrl("/customers/dashboard", true)
//                        .failureUrl("/customers/login?error=true")
//                )
//                .logout(logout -> logout
//                        .logoutUrl("/customers/logout")
//                        .logoutSuccessUrl("/customers/login?logout=true")
//                );
//
//        return http.build();
//    }
    @Autowired
    JwtAuthFilter jwtAuthFilter;
    @Bean
    @Order(2)
    SecurityFilterChain customerSecurity(
            HttpSecurity http,
            DaoAuthenticationProvider customerAuthenticationProvider
    ) throws Exception {

        http
                .securityMatcher("/customers/**")
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sm ->
                        sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(customerAuthenticationProvider)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/customers/authenticate",
                                "/customers/signup",

                                "/customers/ping",
                                "/customers/login",
                                "/css/**",
                                "/images/**"
                        ).permitAll()
                        .anyRequest().hasRole("CUSTOMER")
                )
                .addFilterBefore(jwtAuthFilter,
                        UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }







}
