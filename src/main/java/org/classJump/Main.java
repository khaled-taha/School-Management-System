package org.classJump;

import java.util.*;
import org.classJump.crudStrategies.FileOperations;
import org.classJump.crudStrategies.ObjectStreamFile;
import org.classJump.models.Sheet;
import org.classJump.models.Teacher;

public class Main {

    public static void main(String[] args) {
        FileOperations operations = new ObjectStreamFile();

        ClassJump jump = new ClassJump(operations);

           jump.registerTeacher("khaled","email" ,"123" );
           jump.registerTeacher("khaledtaha","email123" ,"1234" );

           List<Teacher> teachers = operations.findAll();
          teachers.forEach(teacher -> {
              System.out.println(teacher.getName());
          });

          FileOperations<Sheet> teacherFileOperations = new ObjectStreamFile<>();

    }
}



