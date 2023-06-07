package com.example.b2.services;

import com.example.b2.entities.CustomUserDetail;
import com.example.b2.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.b2.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user==null)
            throw new UsernameNotFoundException("User not found");
        return new CustomUserDetail(user);
    }
}
