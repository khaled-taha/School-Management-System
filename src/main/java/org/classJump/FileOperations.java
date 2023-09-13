package org.classJump;

import org.classJump.crudStrategies.CRUDOperations;
import org.classJump.crudStrategies.ObjectStreamFile;
import org.classJump.models.Teacher;

import java.util.List;



public class FileOperations {
    private CRUDOperations crudOperations = new ObjectStreamFile();

    public FileOperations() {
    }

    public FileOperations(CRUDOperations crudOperations) {
        this.crudOperations = crudOperations;
    }


    public void save(Teacher teacher) {
        crudOperations.save(teacher);
    }

    public Teacher find(String username, String password) {
        return crudOperations.find(username, password);
    }

    public List<Teacher> findAll() {
        return crudOperations.findAll();
    }

    public void update(Teacher updatedTeacher, String email) {
        crudOperations.update(updatedTeacher, email);
    }

    public void delete(String email) {
        crudOperations.delete(email);
    }

    public void setCrudOperations(CRUDOperations crudOperations) {
        this.crudOperations = crudOperations;
    }
}
