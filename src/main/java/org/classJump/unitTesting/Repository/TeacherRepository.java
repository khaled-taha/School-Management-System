package org.classJump.unitTesting.Repository;

import org.classJump.repositories.CommaFile;
import org.classJump.repositories.FileRepository;
import org.classJump.models.Teacher;

import java.lang.reflect.Method;

public class TeacherRepository {
    FileRepository<Teacher> operations = new CommaFile<>(Teacher.class);

    private boolean testSaveMethod(){
        boolean status = false;
        // Implementation
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

    public static void main(String[] args) {
        TeacherRepository repository = new TeacherRepository();

        // Use reflection to call the test methods
        Class<TeacherRepository> clazz = TeacherRepository.class;
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
