package org.classJump.crudStrategies;

import org.classJump.models.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CommaFile implements CRUDOperations{

    private File file;
    private String path = "comma.txt";

    public CommaFile() {
        this.file = new File(path);
    }

    public CommaFile(String path) {
        this.file = new File(path);
    }

    @Override
    public void save(Teacher teacher) {
        try (FileOutputStream out = new FileOutputStream(this.file, true);
             PrintWriter writer = new PrintWriter(out)) {
            String line = teacher.getName() + "," + teacher.getEmail() + "," + teacher.getpassword();
            writer.println(line);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Teacher find(String username, String password) {
        try (FileReader fin = new FileReader(this.path);
             BufferedReader reader = new BufferedReader(fin)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String savedUsername = line.split(",")[0];
                String savedEmail = line.split(",")[1];
                if (username.equals(savedUsername) && password.equals(savedEmail)) {
                    return new Teacher(savedUsername, savedEmail, line.split(",")[2]);
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

        try (FileReader fin = new FileReader(this.path);
             BufferedReader reader = new BufferedReader(fin)) {

            String line;
            while ((line = reader.readLine()) != null) {
                teachers.add(new Teacher(line.split(",")[0], line.split(",")[1], line.split(",")[2]));
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
        try (FileOutputStream out = new FileOutputStream(this.file);
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
