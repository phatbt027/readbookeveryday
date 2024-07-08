package com.btphat.readbookeveryday.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.btphat.readbookeveryday.entity.User;

public class MyUserDetails implements UserDetails {

    private User user;

    public MyUserDetails(User user) {
        this.user = user;
    }

    public Collection<GrantedAuthority> getAuthorities() {
      SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().toString());
      return Arrays.asList(authority);
   }

   public String getPassword() {

      return user.getPassword();
   }

   public String getUsername() {

      return user.getUsername();
   }

   public boolean isEnabled() {
      return user.isEnabled();
   }

   public boolean isAccountNonExpired() {
      return true;
   }

   public boolean isAccountNonLocked() {
      return true;
   }

   public boolean isCredentialsNonExpired() {
      return true;
   }
}
