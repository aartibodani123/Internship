package com.example.demo.controller;

import com.example.demo.model.AuthRequest;
import com.example.demo.model.JwtResponse;
import com.example.demo.util.JWTUtil;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class AuthController {
    @GetMapping("/ping")
    public String ping() {
        return "JWT CONTROLLER ALIVE";
    }

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    public AuthController(
            @Qualifier("customerAuthenticationManager")
            AuthenticationManager authenticationManager,
            JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(
            @RequestBody AuthRequest authRequest,
            jakarta.servlet.http.HttpServletResponse response) {

        try {
            Authentication authentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    authRequest.getEmail(),
                                    authRequest.getPassword()
                            )
                    );
           // If login is successful authentication now contains
            // information about the logged-in user


            //extracting user details from the authentication (authenticated user)
            UserDetails user =
                    (UserDetails) authentication.getPrincipal();

            String token = jwtUtil.generateToken(user);

            Cookie cookie = new Cookie("jwt", token);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            cookie.setMaxAge(2 * 60 * 60); // 2 hours
            response.addCookie(cookie);

            return ResponseEntity.ok().build();

        } catch (BadCredentialsException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid email or password");
        }
    }

}
