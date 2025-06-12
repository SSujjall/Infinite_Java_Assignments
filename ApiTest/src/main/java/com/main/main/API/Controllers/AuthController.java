package com.main.main.API.Controllers;

import com.main.main.API.DTOs.Auth.LoginDTO;
import com.main.main.API.DTOs.Auth.LoginResponseDTO;
import com.main.main.Services.Helpers.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
        String jwt = jwtHelper.generateToken(user.getUsername());

        return ResponseEntity.ok(new LoginResponseDTO(jwt));
    }
}
