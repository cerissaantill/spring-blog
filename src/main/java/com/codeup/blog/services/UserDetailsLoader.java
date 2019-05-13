package com.codeup.blog.services;

import com.codeup.blog.Users;
import com.codeup.blog.models.User;
import com.codeup.blog.models.UserWithRoles;
import com.codeup.blog.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



@Service
public class UserDetailsLoader implements UserDetailsService {
    private final User users;

    public UserDetailsLoader(Users users) {
        this.users = users;
    }



    @Override
    public UserDetailsLoader loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);

        }
        return new UserWithRoles(user);
    }



}
