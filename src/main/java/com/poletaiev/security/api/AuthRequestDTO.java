package com.poletaiev.security.api;

import lombok.Data;

@Data
public class AuthRequestDTO {
    private String email;
    private String password;
}
