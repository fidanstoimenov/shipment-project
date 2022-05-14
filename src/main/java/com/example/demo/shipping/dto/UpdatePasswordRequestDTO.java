package com.example.demo.shipping.dto;

import com.example.demo.security.Role;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UpdatePasswordRequestDTO {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotNull
    private Role role;
}
