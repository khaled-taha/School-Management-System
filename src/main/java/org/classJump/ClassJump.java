package org.classJump;

import org.classJump.crudStrategies.FileOperations;
import org.classJump.models.Teacher;


public class ClassJump {

   // private ArrayList<Teacher> teachers;
    private FileOperations file;
    public ClassJump(FileOperations file){
        this.file = file;
    }



    public void registerTeacher(String name, String email, String password) {
            this.file.save(new Teacher(name, email, password));
    }



    public boolean loginTeacher(String username, String password){
            Teacher teacher =  this.file.find(username, password);
            if(teacher != null) return true;
            return false;
    }
}
