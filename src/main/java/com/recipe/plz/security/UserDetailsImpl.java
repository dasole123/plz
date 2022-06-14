package com.recipe.plz.security;

import com.recipe.plz.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {

    private final Users users; //조회가 된 유저정보

    public UserDetailsImpl(Users users) {
        this.users = users;
    }

    public Users getUser() {
        return users;
    }


    //하나의 유저정보를 각각 뽑아냄
    @Override
    public String getPassword() {
        return users.getPassword();
    }

//    public String getEmail() { return users.getEmail();}

    @Override
    public String getUsername() { return users.getUsername(); }

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

    @Override // 인가를 해주는 부분
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }


}
