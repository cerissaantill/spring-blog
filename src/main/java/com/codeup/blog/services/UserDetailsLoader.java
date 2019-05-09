package com.codeup.blog.services;


import com.codeup.blog.models.User;
import com.codeup.blog.models.UserWithRoles;
import com.codeup.blog.repositories.UserRepository;
import org.springframework.stereotype.Service;



@Service
public class UserDetailsLoader implements UserDetailService {

    private final UserRepository users;

    public UserDetailsLoader(UserRepository users) {
        this.users = users;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);

        }
        return new UserWithRoles(user);
    }



}
