package com.course.project.Fapi.service.implementations;

import com.course.project.Fapi.config.Constants;
import com.course.project.Fapi.config.JwtTokenUtil;
import com.course.project.Fapi.entity.User;
import com.course.project.Fapi.propertys.BackendApiProperties;
import com.course.project.Fapi.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private BackendApiProperties backendApiProperties;

    @Autowired
    private UserRoleServiceImpl roleService;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenProvider;

    private final RestTemplate restTemplate;

    public UserServiceImpl(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public User create(User user) {
        return restTemplate.postForObject(backendApiProperties.getUserUri(),user,User.class);
    }

    @Override
    public User findById(long id) {
       return restTemplate.getForObject(backendApiProperties.getUserUri()+"/"+id, User.class);
    }


    //Возможна проблема из-за Objects.requireNonNull
    @Override
    public List<User> getAll(int page, int size) {
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(backendApiProperties.getUserUri()
                + "/find-all/?pageNo=" + page + "&pageSize=" + size, User[].class)));
    }

    @Override
    public void deleteById(long id) {
        restTemplate.delete(backendApiProperties.getUserUri() + "/" + id);
    }

    @Override
    public int getSize() {
        return Objects.requireNonNull(restTemplate.getForObject
                (backendApiProperties.getUserUri()+"/size", Integer.class));
    }

    public String getLogin(String bearerToken) {
        String login = null;
        String authToken = bearerToken.replace(Constants.TOKEN_PREFIX, "");
        try {
            login = jwtTokenProvider.getUsernameFromToken(authToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return login;
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet();
        authorities.add(new SimpleGrantedAuthority(roleService.findById(user.getRoleId().getId()).getUserRole()));
        return authorities;
    }

    @Override
    public User findByEmail(String login) {
        return restTemplate.getForObject(backendApiProperties.getUserUri()
                +"/find-by-Email/" + login, User.class);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = findByEmail(login);
        if(user == null){
            throw new UsernameNotFoundException("Invalid login!");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), getAuthority(user));
    }
}
