/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demoexcel32.repository;

import com.example.demoexcel32.document.Masters;
import com.example.demoexcel32.model.Master;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Rey Messon
 */

public interface MasterRepository extends MongoRepository<Masters, Integer> {
    
    @Query(value="{ _id : ?0 }")
    List<Masters> getMastersById(String id);
    
    //@Query(value="{'_id':'3'},{$set:{'name':'Cocina Basica 5'}}")
    @Query(value="db.masters.update({'_id':'3'},{$set:{'name':'Cocina Basica 7'}});")            
    List<Masters> setMastersById();

}