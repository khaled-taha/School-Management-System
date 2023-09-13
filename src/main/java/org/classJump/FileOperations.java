package org.classJump;

import org.classJump.models.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class FileOperations {
    private File file;
    private String path;

    public FileOperations(String path) {
        this.file = new File(path);
    }

    // saveToFile
    public void save(Teacher teacher) {
        try ( FileOutputStream out = new FileOutputStream(this.file, true);
                CustomObjectOutputStream cout = new CustomObjectOutputStream(out);) {
            if (this.file.length() == 0) {
                writeFirstObject(teacher);
            } else{
                cout.writeObject(teacher);
                cout.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeFirstObject(Teacher teacher){
        try ( FileOutputStream out = new FileOutputStream(this.file, true);
              ObjectOutputStream obut = new ObjectOutputStream(out)) {
                obut.writeObject(teacher);
                obut.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Teacher findTeacher(String username, String password) {
        Teacher savedTeacher;

        try ( FileInputStream fin = new FileInputStream(this.path);
              ObjectInputStream in = new ObjectInputStream(fin)) {

            while ((savedTeacher = (Teacher) in.readObject()) != null) {
                if (username.equals(savedTeacher.getName()) && password.equals(savedTeacher.getPassWord())) {
                    return savedTeacher;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Teacher> getAll() {
        Teacher savedTeacher;
        List<Teacher> teachers = new ArrayList<>();

        try ( FileInputStream fin = new FileInputStream(this.file);
              ObjectInputStream in = new ObjectInputStream(fin);) {

            while ((savedTeacher = (Teacher) in.readObject()) != null) {
                teachers.add(savedTeacher);
            }
        } catch (Exception e) {
            System.out.println("End File...........");
        }

        return teachers;
    }

    public void update(Teacher updatedTeacher, String email) {
        List<Teacher> teachers = getAll();

        for (int i = 0; i < teachers.size(); i++) {
            Teacher teacher = teachers.get(i);

            if (email.equals(updatedTeacher.getEmail())) {
                teachers.set(i, updatedTeacher);
                saveAll(teachers);
                return;
            }
        }
        System.out.println("Teacher not found for update.");
    }

    public void delete(String email) {
        List<Teacher> teachers = getAll();

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
        try (FileOutputStream out = new FileOutputStream(this.file, false);
             ObjectOutputStream cout = new ObjectOutputStream(out)) {
            int index = 0;
            for (Teacher teacher : teachers) {
                if(index == 0){
                    this.writeFirstObject(teacher);
                }else {
                    cout.writeObject(teacher);
                    cout.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
