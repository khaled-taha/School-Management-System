package org.classJump.unitTesting.Repository;

import org.apache.poi.ss.formula.functions.T;
import org.classJump.repositories.CommaFile;
import org.classJump.repositories.FileRepository;
import org.classJump.models.Teacher;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeacherRepositoryComma {
    FileRepository<Teacher> teacherFileRepository = new CommaFile<>(Teacher.class);
    private List<Teacher> teachers = Arrays.asList(
            new Teacher("ahmed", "email", "123"),
            new Teacher("khaled", "Gmail", "1234")
    );

    public TeacherRepositoryComma() throws Exception {
        List<Teacher> list = this.teacherFileRepository.findAll();
        list.forEach(teacher -> {
            try {
                this.teacherFileRepository.delete(teacher);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private boolean testSaveMethod() throws Exception {
        boolean status = false;
        // save
        this.teacherFileRepository.save(this.teachers.get(0));
        // expected
        List<Teacher> list = this.teacherFileRepository.findAll();
        for (Teacher teacher: list) {
            if(teacher.equals(this.teachers.get(0))){
                status = true;
                break;
            }
        }
        return status;
    }

    private boolean testFindMethod(){
        boolean status = false;
        // Implementation
        return status;
    }

    private boolean testUpdateMethod(){
        boolean status = false;
        // Implementation
        return status;
    }

    private boolean testDeleteMethod(){
        boolean status = false;
        // Implementation
        return status;
    }

    private boolean testFindAllMethod(){
        boolean status = false;
        // Implementation
        return status;
    }

    public static void main(String[] args) throws Exception {
        TeacherRepositoryComma repository = new TeacherRepositoryComma();

        // Use reflection to call the test methods
        Class<TeacherRepositoryComma> clazz = TeacherRepositoryComma.class;
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().startsWith("test")) {
                try {
                    boolean result = (boolean) method.invoke(repository);
                    System.out.println(method.getName() + ": " + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
