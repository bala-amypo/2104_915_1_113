package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthServiceImpl {

    private final AppUserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtTokenProvider jwt;

    public AuthServiceImpl(AppUserRepository u, RoleRepository r,
                           PasswordEncoder e, AuthenticationManager a,
                           JwtTokenProvider j) {
        userRepo = u; roleRepo = r; encoder = e; authManager = a; jwt = j;
    }

    public void register(RegisterRequest req) {
        if (userRepo.existsByEmail(req.getEmail()))
            throw new IllegalArgumentException("Email exists");

        Role role = roleRepo.findByName(req.getRole())
                .orElseThrow();

        AppUser user = new AppUser();
        user.setEmail(req.getEmail());
        user.setPassword(encoder.encode(req.getPassword()));
        user.setFullName(req.getFullName());
        user.getRoles().add(role);

        userRepo.save(user);
    }

    public JwtResponse login(LoginRequest req) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getEmail(), req.getPassword()
                ));

        AppUser user = userRepo.findByEmail(req.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Role role = user.getRoles().iterator().next();
        String token = jwt.generateToken(auth, user.getId(),
                user.getEmail(), role.getName());

        return new JwtResponse(token, user.getEmail(), role.getName());
    }
}
