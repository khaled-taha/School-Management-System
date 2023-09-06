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

    // Update
    // Delete



}
