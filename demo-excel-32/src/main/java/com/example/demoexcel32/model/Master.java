/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demoexcel32.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rey Messon
 */
public class Master {

    private String id = "";
    private String name = "";
    private boolean active = true;
    private List<Detail> details = new ArrayList<Detail>();   
    private String creator = "";
    private Date created = new Date();

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }
        /**
     * @return the details
     */
    public List<Detail> getDetails() {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(List<Detail> details) {
        this.details = details;
    }
    
        /**
     * @return the creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator the creator to set
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * @return the created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(Date created) {
        this.created = created;
    }
        
}