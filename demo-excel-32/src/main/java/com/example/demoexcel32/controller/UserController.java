/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demoexcel32.controller;

import com.example.demoexcel32.document.Users;
import com.example.demoexcel32.repository.UserRepository;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    
    public UserController(UserRepository userRepository){
        
        this.userRepository = userRepository;    
    }
    
    @CrossOrigin(origins="http://localhost:4200")
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> getUsers() throws Exception{

        return userRepository.findAll();
    }

    
    
    
}
