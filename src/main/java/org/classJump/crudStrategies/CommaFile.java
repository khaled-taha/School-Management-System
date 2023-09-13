package org.classJump.crudStrategies;

import org.classJump.models.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CommaFile extends FileOperations{

    public CommaFile() {
        super("comma.txt");
    }

    public CommaFile(String path) {
        super(path);
    }

    @Override
    public void save(Teacher teacher) {
        try (FileOutputStream out = new FileOutputStream(this.getFile(), true);
             PrintWriter writer = new PrintWriter(out)) {
            String line = teacher.getName() + "," + teacher.getEmail() + "," + teacher.getpassword();
            writer.println(line);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Teacher find(String username, String password) {
        try (FileReader fin = new FileReader(this.getPath());
             BufferedReader reader = new BufferedReader(fin)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes.length == 3 &&
                        username.equals(attributes[0]) && password.equals(attributes[2])) {
                    return new Teacher(attributes[0], attributes[1], attributes[2]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Teacher> findAll() {
        ArrayList<Teacher> teachers = new ArrayList<>();

        try (FileReader fin = new FileReader(this.getPath());
             BufferedReader reader = new BufferedReader(fin)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                if(attributes.length == 3)
                    teachers.add(new Teacher(attributes[0], attributes[1], attributes[2]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return teachers;
    }

    @Override
    public void update(Teacher updatedTeacher, String email) {
        List<Teacher> teachers = findAll();

        for (int i = 0; i < teachers.size(); i++) {
            Teacher teacher = teachers.get(i);

            if (teacher.getEmail().equals(email)) {
                teachers.set(i, updatedTeacher);
                saveAll(teachers);
                return;
            }
        }
        System.out.println("Teacher not found for update.");
    }

    @Override
    public void delete(String email) {
        List<Teacher> teachers = findAll();

        for (int i = 0; i < teachers.size(); i++) {
            Teacher teacher = teachers.get(i);

            if (teacher.getEmail().equals(email)) {
                teachers.remove(i);
                saveAll(teachers);
                return;
            }
        }
        System.out.println("Teacher not found for delete.");
    }

    private void saveAll(List<Teacher> teachers) {
        try (FileOutputStream out = new FileOutputStream(this.getFile());
             PrintWriter writer = new PrintWriter(out)) {
            teachers.forEach(teacher -> {
                String line = teacher.getName() + "," + teacher.getEmail() + "," + teacher.getpassword();
                writer.println(line);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
