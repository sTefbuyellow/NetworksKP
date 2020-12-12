package com.course.project.Fapi.service.implementations;

import com.course.project.Fapi.entity.User;
import com.course.project.Fapi.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRoleServiceImpl userRoleService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.findByName(name);
        UserRole userRole = userRoleService.findById(Long.parseLong(user.getRoleId()));
        return new org.springframework.security.core.userdetails.User(user.getName(),
                user.getPassword(),
                true,true,true,true,
                getAuthorities(userRole.getUserRole()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String userRole){
        return Collections.singletonList(new SimpleGrantedAuthority(userRole));
    }
}
