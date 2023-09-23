package org.classJump;

import java.util.*;

import org.apache.poi.ss.formula.functions.T;
import org.classJump.repositories.CommaFile;
import org.classJump.repositories.FileRepository;
import org.classJump.models.Teacher;

public class Main {

    public static void main(String[] args) throws Exception {
        FileRepository<Teacher> operations = new CommaFile<>(Teacher.class);

        operations.save(new Teacher("khaled","email" ,"123" ));
        operations.save(new Teacher("khaledtaha","email123" ,"1234" ));
        List<Teacher> teachers = operations.findAll();

        System.out.println("Find All Method: ");
        teachers.forEach(teacher -> {
            System.out.println(teacher.getName());
          });
        System.out.println("----------------------------------");

        System.out.println("Find Method: ");
        Teacher teacher = operations.find(new Teacher("khaled","email" ,"123" ));
        System.out.println(teacher);
        System.out.println("----------------------------------");

    }

}




