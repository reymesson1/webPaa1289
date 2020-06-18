/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demoexcel32.controller;

import com.example.demoexcel32.document.Users;
import com.example.demoexcel32.repository.UserRepository;
import com.example.demoexcel32.util.AuthenticationRequest;
import com.example.demoexcel32.util.AuthenticationResponse;
import com.example.demoexcel32.util.JwtUtil;
import com.example.demoexcel32.util.MyUserDetailsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rey Messon
 */

@RestController
public class UserController {
    
    private UserRepository userRepository;

    @Autowired    
    private AuthenticationManager authenticationManager;

    @Autowired    
    private JwtUtil jwtTokenUtil;

    @Autowired    
    private MyUserDetailsService userDetailsService;
    
    public UserController(UserRepository userRepository){
        
        this.userRepository = userRepository;    
    }
    
    @CrossOrigin(origins="http://localhost:4200")
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
                );
        }
        catch (BadCredentialsException e) {
                throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                        .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    
    @CrossOrigin(origins="http://localhost:4200")
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> getUsers() throws Exception{

        return userRepository.findAll();
    }

    
    
    
}
