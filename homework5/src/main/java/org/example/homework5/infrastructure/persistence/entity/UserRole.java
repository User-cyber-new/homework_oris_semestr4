package org.example.homework5.infrastructure.persistence.entity;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

public enum UserRole {
    ADMIN,
    USER;

    public GrantedAuthority getRoleGrantedAuthority(){
        return new GrantedAuthority() {
            @Override
            public @Nullable String getAuthority() {
                return "ROLE_" + name();
            }
        };
    }
}
