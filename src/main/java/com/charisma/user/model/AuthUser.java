package com.charisma.user.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Set;

/**
 * Simple implementation of {@link Authentication} to encapsulates the authenticated user details.
 *
 */
@Getter
@RequiredArgsConstructor
public final class AuthUser implements Authentication {

    /**
     * Represents the user authorities.
     */
    private final Set<GrantedAuthority> authorities;

    /**
     * Determines the token has been authenticated.
     */
    private boolean authenticated = true;


    private final String sessionId;


    private final Long userId;

    /**
     * Represents the user's device identifier.
     */
    private final String deviceUid;


    private final String username;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return null;
    }
}
