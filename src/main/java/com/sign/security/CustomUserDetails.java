package com.sign.security;

import com.sign.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("serial")
public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Wrap your single String role into a GrantedAuthority
        return Collections.singleton((GrantedAuthority) () -> user.getRole());
    }

    @Override
    public String getPassword() {
        return user.getPasswordHash();  // or your actual getter
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override public boolean isAccountNonExpired()     { return true; }
    @Override public boolean isAccountNonLocked()      { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled()               { return true; }

    public User getUser() {
        return user;
    }
}
