package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public String login() {
        return "Application running without security";
    }
}
