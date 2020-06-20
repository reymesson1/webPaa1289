package com.example.demoexcel32.util;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rey Messon
 */
import com.example.demoexcel32.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
    
    private UserRepository userRepository;
    
    public MyUserDetailsService(UserRepository userRepository){
    
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        
        User user = userRepository.findByUsername(s);

        if(user == null){
            throw new UsernameNotFoundException(s);
        }else{
//            UserDetails details = new UserDetails(user);
//            return details;
            System.out.println(user);

            return new User("foo", "foo", new ArrayList<>());        
        }
        
//        return new User("foo", "foo", new ArrayList<>());
    }
}

