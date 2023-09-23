package org.classJump.repositories;

import java.io.File;
import java.util.List;



public abstract class FileRepository<T> {
    private File file;
    private String path;

    public FileRepository(String path) {
        this.path = path;
        this.file = new File(path);
    }
    public abstract void save(T model) throws Exception;
    public abstract void saveAll(List<T> models) throws Exception;

    public abstract T find(T Model) throws Exception;

    public abstract List<T> findAll() throws Exception;

    public abstract void update(T oldModel, T updatedModel) throws Exception;

    public abstract void delete(T Model) throws Exception;

    public File getFile() {
        return file;
    }

    public String getPath() {
        return path;
    }
}
