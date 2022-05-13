package com.example.demo.security;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    POSTMAN,
    SENDER;

    @Override
    public String getAuthority() {
        return name();
    }
}
