/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demoexcel32.repository;

import com.example.demoexcel32.document.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rey Messon
 */

@Repository
public interface UserRepository extends MongoRepository<Users, Integer> {

   @Query
    public Users findByUsername(String username);
    
}
