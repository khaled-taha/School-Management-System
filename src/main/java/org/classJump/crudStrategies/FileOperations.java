package org.classJump.crudStrategies;

import org.classJump.models.Teacher;

import java.io.File;
import java.util.List;



public abstract class FileOperations {

    private File file;
    private String path;

    public FileOperations(String path) {
        this.path = path;
        this.file = new File(path);
    }

    public abstract void save(Teacher teacher);

    public abstract Teacher find(String username, String password);

    public abstract List<Teacher> findAll();

    public abstract void update(Teacher updatedTeacher, String email);

    public abstract void delete(String email);

    public File getFile() {
        return file;
    }

    public String getPath() {
        return path;
    }
}
