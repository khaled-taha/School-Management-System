/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.classJump.models;

import org.classJump.Exceptions.LectureNotFoundException;
import org.classJump.Exceptions.SheetNotFoundException;

import java.util.ArrayList;

/**
 *
 * @author CoNNect
 */
public class Course {

    private String name;
    private String description;
    private ArrayList<Lecture> Lectures;
    private ArrayList<Sheet> Sheets;

    public Course(String courseName, String description, ArrayList<Lecture> Lectures, ArrayList<Sheet> Sheets) {
        this.name = courseName;
        this.description = description;
        this.Lectures = new ArrayList();
        this.Sheets = new ArrayList();
    }

    public void addLecture(Lecture lecture) {
        Lectures.add(lecture);
    }

    public void deleteLecture(String lectureName) {
        try {
            ArrayList<Lecture> lectures = this.searchLecture(lectureName);
            this.Lectures.removeAll(lectures);

        } catch (LectureNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public void addSheet(Sheet sheet) {
        Sheets.add(sheet);
    }

    public void deleteSheet(String fileName) {
        try {
            ArrayList<Sheet> sheets = this.searchSheets(fileName);
            this.Sheets.removeAll(sheets);
        }catch (SheetNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
           
    public ArrayList<Lecture> getLectures() {
        return Lectures;
    }

    public void setLectures(ArrayList<Lecture> Lectures) {
        this.Lectures = Lectures;
    }

    public ArrayList<Sheet> getSheets() {
        return Sheets;
    }

    public void setSheets(ArrayList<Sheet> Sheets) {
        this.Sheets = Sheets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private ArrayList<Lecture> searchLecture(String lectureName) throws LectureNotFoundException{
        ArrayList<Lecture> lectures = new ArrayList<>();
        for (Lecture lecture : this.Lectures) {
            if (lecture.getName()!=null&&lecture.getName().equalsIgnoreCase(lectureName)) {
                lectures.add(lecture);
            }
            return lectures;
        }
        throw new LectureNotFoundException("Lecture'"+lectureName+"'not found in course'"+name+"'");
    }

    private ArrayList<Sheet> searchSheets(String fileName) throws SheetNotFoundException {
        ArrayList<Sheet> sheets = new ArrayList<>();
        for (Sheet sheet : this.Sheets) {
            if (sheet.getFileName()!=null&&sheet.getFileName().equalsIgnoreCase(fileName)) {
                sheets.add(sheet);
            }
            return sheets;
        }
       throw new SheetNotFoundException("Sheet'"+fileName+"'not found in course'"+name+"'");
    }

}
