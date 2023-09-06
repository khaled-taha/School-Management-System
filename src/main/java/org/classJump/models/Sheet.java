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
public class Sheet {

    private String number;
    private String description;
    private String fileName;

    public Sheet(String sheetNumbers, String discription, String fileName) {
        this.number = sheetNumbers;
        this.description = discription;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getNumbers() {
        return number;
    }

    public void setNumbers(String sheetNumbers) {
        this.number = sheetNumbers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
