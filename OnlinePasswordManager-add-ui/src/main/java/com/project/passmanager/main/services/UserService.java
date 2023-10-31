package com.project.passmanager.main.services;

import com.project.passmanager.main.database.models.Role;
import com.project.passmanager.main.database.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component

public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.project.passmanager.main.database.models.User myUser = userRepository.findByUsername(username);
        return new User(myUser.getUsername(), myUser.getPassword(), mapRolesToAthorities(myUser.getRoles()));
    }
    private List<? extends GrantedAuthority> mapRolesToAthorities (Set<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_"+ role.name())).collect(Collectors.toList());
    }
    public void addUser(com.project.passmanager.main.database.models.User user) throws Exception
    {
        com.project.passmanager.main.database.models.User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb != null)
        {
            throw new Exception("user exist");
        }
        user.setRoles(Collections.singleton(Role.USER));
        user.setActive(true);
        userRepository.save(user);
    }
}
