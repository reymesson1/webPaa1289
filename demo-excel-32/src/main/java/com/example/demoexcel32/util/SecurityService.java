/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demoexcel32.util;

/**
 *
 * @author Rey Messon
 */
public interface SecurityService {
  String createToken(String subject, long ttlMillis);    
 // other methods  
}
