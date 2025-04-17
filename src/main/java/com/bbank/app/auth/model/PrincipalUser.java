package com.bbank.app.auth.model;

import com.bbank.app.model.LoginUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalUser implements UserDetails {
    private final transient LoginUser loginUser;
    public PrincipalUser(LoginUser loginUser) {
        this.loginUser = loginUser;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<SimpleGrantedAuthority>();
    }

    @Override
    public String getPassword() {
        return loginUser.getPassword();
    }

    @Override
    public String getUsername() {
        return loginUser.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
