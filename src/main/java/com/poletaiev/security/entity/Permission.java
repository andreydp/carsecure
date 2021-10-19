package com.poletaiev.security.entity;

/**
 * Created by andrey on 19.10.2021.
 */
public enum Permission {
    USERS_READ("users:read"),
    USERS_WRITE("users:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
