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
public class Exam {
    
    private String id = "";
    private Date date = new Date();
    private String name = "";
    private List<Question> questions = new ArrayList<Question>();
    private int grandTotal = 0;
    private String student = "";
    private Date created = new Date();
    private String creator = "";

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
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the questions
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * @param questions the questions to set
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    /**
     * @return the grandTotal
     */
    public int getGrandTotal() {
        return grandTotal;
    }

    /**
     * @param grandTotal the grandTotal to set
     */
    public void setGrandTotal(int grandTotal) {
        this.grandTotal = grandTotal;
    }

    /**
     * @return the student
     */
    public String getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(String student) {
        this.student = student;
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

    
    
    
}
