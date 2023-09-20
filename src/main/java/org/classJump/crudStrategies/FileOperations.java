package org.classJump.crudStrategies;

import org.classJump.models.Teacher;
import java.io.File;
import java.util.List;



public abstract class FileOperations<T> {
    private File file;
    private String path;

    public FileOperations(String path) {
        this.path = path;
        this.file = new File(path);
    }
    public abstract void save(T model);

    public abstract Teacher find(T Model);

    public abstract List<T> findAll();

    public abstract void update(T oldModel, T updatedModel);

    public abstract void delete(T Model);

    public File getFile() {
        return file;
    }

    public String getPath() {
        return path;
    }
}
