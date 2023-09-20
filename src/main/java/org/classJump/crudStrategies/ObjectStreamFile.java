package org.classJump.crudStrategies;

import org.apache.poi.ss.formula.functions.T;
import org.classJump.CustomObjectOutputStream;
import org.classJump.models.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectStreamFile<T> extends FileOperations<T>{

    public ObjectStreamFile() {
        super("objectStream.txt");
    }

    public ObjectStreamFile(String path) {
        super(path);
    }

    @Override
    public void save(T teacher) {
        try (FileOutputStream out = new FileOutputStream(this.getFile(), true);
             CustomObjectOutputStream cout = new CustomObjectOutputStream(out)) {
            if (this.getFile().length() == 0) {
                writeFirstObject(teacher);
            } else{
                cout.writeObject(teacher);
                cout.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Teacher find(T teacher) {
        Teacher savedTeacher;

        try (FileInputStream fin = new FileInputStream(this.getPath());
             ObjectInputStream in = new ObjectInputStream(fin)) {

            while ((savedTeacher = (Teacher) in.readObject()) != null) {
                if (teacher.equals(savedTeacher)) {
                    return savedTeacher;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<T> findAll() {
        T savedTeacher;
        List<T> teachers = new ArrayList<>();

        try ( FileInputStream fin = new FileInputStream(this.getFile());
              ObjectInputStream in = new ObjectInputStream(fin);) {

            while ((savedTeacher = (T) in.readObject()) != null) {
                teachers.add(savedTeacher);
            }
        } catch (Exception e) {
            System.out.println("End File...........");
        }

        return teachers;
    }

    @Override
    public void update(T oldTeacher, T updatedTeacher) {
        List<T> teachers = findAll();

        for (int i = 0; i < teachers.size(); i++) {
            T teacher = teachers.get(i);

            if (teacher.equals(oldTeacher)) {
                teachers.set(i, updatedTeacher);
                saveAll(teachers);
                return;
            }
        }
        System.out.println("Teacher not found for update.");
    }


    @Override
    public void delete(T teacher) {
        List<T> teachers = findAll();

        for (int i = 0; i < teachers.size(); i++) {
            T savedTeacher = teachers.get(i);

            if (teacher.equals(savedTeacher)) {
                teachers.remove(i);
                saveAll(teachers);
                return;
            }
        }
        System.out.println("Teacher not found for delete.");
    }

    private void writeFirstObject(T teacher){
        try ( FileOutputStream out = new FileOutputStream(this.getFile(), true);
              ObjectOutputStream obut = new ObjectOutputStream(out)) {
            obut.writeObject(teacher);
            obut.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveAll(List<T> teachers) {
        try (FileOutputStream out = new FileOutputStream(this.getFile());
             ObjectOutputStream cout = new ObjectOutputStream(out)) {
            int index = 0;
            for (T teacher : teachers) {
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
