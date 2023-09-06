/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.classJump.models;

/**
 *
 * @author CoNNect
 */
public class Lecture {
    private String name;
    private String description;
    private String fileName;

    public Lecture(String lectureName, String discription, String fileName) {
        this.name = lectureName;
        this.description = discription;
        this.fileName = fileName;
    }
   
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String lectureName) {
        this.name = lectureName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
       
}
