package org.classJump.crudStrategies;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectStreamFile<T> extends FileRepository<T> {

    public ObjectStreamFile() {
        super("objectStream.txt");
    }

    public ObjectStreamFile(String path) {
        super(path);
    }

    @Override
    public void save(T model) throws Exception {
        try (FileOutputStream out = new FileOutputStream(this.getFile(), true);
             CustomObjectOutputStream cout = new CustomObjectOutputStream(out)) {
            if (this.getFile().length() == 0) {
                writeFirstObject(model);
            } else{
                cout.writeObject(model);
                cout.flush();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public T find(T model) throws Exception {
        T savedModel;

        try (FileInputStream fin = new FileInputStream(this.getPath());
             ObjectInputStream in = new ObjectInputStream(fin)) {

            while ((savedModel = (T) in.readObject()) != null) {
                if (model.equals(savedModel)) {
                    return savedModel;
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return null;
    }

    @Override
    public List<T> findAll() throws Exception {
        T savedModel;
        List<T> models = new ArrayList<>();

        try ( FileInputStream fin = new FileInputStream(this.getFile());
              ObjectInputStream in = new ObjectInputStream(fin);) {

            while ((savedModel = (T) in.readObject()) != null) {
                models.add(savedModel);
            }
        } catch (Exception e) {
           throw new Exception(e.getMessage());
        }

        return models;
    }

    @Override
    public void update(T oldModel, T updatedModel) throws Exception {
        List<T> models = findAll();

        for (int i = 0; i < models.size(); i++) {
            T teacher = models.get(i);

            if (teacher.equals(oldModel)) {
                models.set(i, updatedModel);
                saveAll(models);
                return;
            }
        }
        System.out.println(oldModel.getClass().getName() + " not found for update.");
    }


    @Override
    public void delete(T model) throws Exception {
        List<T> models = findAll();

        for (int i = 0; i < models.size(); i++) {
            T savedTeacher = models.get(i);

            if (model.equals(savedTeacher)) {
                models.remove(i);
                saveAll(models);
                return;
            }
        }
        System.out.println(model.getClass().getName() + " not found for delete.");
    }

    private void writeFirstObject(T model) throws Exception {
        try ( FileOutputStream out = new FileOutputStream(this.getFile(), true);
              ObjectOutputStream obut = new ObjectOutputStream(out)) {
            obut.writeObject(model);
            obut.flush();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void saveAll(List<T> models) throws Exception {
        try (FileOutputStream out = new FileOutputStream(this.getFile());
             ObjectOutputStream cout = new ObjectOutputStream(out)) {
            int index = 0;
            for (T model : models) {
                if(index == 0){
                    this.writeFirstObject(model);
                }else {
                    cout.writeObject(model);
                    cout.flush();
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
