package org.classJump.crudStrategies;

import org.classJump.models.Teacher;

import java.util.List;

public interface CRUDOperations {
    void save(Teacher teacher);
    Teacher find(String username, String password);
    List<Teacher> findAll();
    void update(Teacher updatedTeacher, String email);
    void delete(String email);
}
