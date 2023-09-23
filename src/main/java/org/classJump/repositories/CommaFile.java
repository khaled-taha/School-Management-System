package org.classJump.repositories;

import org.classJump.utils.ToStringParsing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CommaFile<T> extends FileRepository<T> {

    private Class<T> modelClass;

    public CommaFile(Class<T> modelClass) {
        super("comma.txt");
        this.modelClass = modelClass;
    }

    public CommaFile(String path, Class<T> modelClass) {
        super(path);
        this.modelClass = modelClass;
    }

    @Override
    public void save(T model) throws Exception {
        try (FileOutputStream out = new FileOutputStream(this.getFile(), true);
             PrintWriter writer = new PrintWriter(out)) {

             String[] attributes = ToStringParsing.extractAttributes(model.toString());
             String line = attributes[0] + "," + attributes[1] + "," + attributes[2];
             writer.println(line);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public T find(T model) throws Exception {
        try (FileReader fin = new FileReader(this.getPath());
             BufferedReader reader = new BufferedReader(fin)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] storedAttributes = line.split(",");
                String[] modelAttributes = ToStringParsing.extractAttributes(model.toString());
                if (storedAttributes.length == 3 &&
                        modelAttributes[0].equals(storedAttributes[0])
                        && modelAttributes[1].equals(storedAttributes[1])
                        && modelAttributes[2].equals(storedAttributes[2])) {
                    return model;
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return null;
    }

    @Override
    public List<T> findAll() throws Exception {
        ArrayList<T> objects = new ArrayList<>();

        try (FileReader fin = new FileReader(this.getPath());
             BufferedReader reader = new BufferedReader(fin)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes.length == 3) {
                    // Use reflection to create an instance of the specified class
                    T obj = this.modelClass.getDeclaredConstructor(String[].class).newInstance((Object) attributes);
                    objects.add(obj);
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return objects;
    }

    @Override
    public void update(T oldModel, T updatedModel) throws Exception {
        List<T> models = findAll();

        for (int i = 0; i < models.size(); i++) {
            T model = models.get(i);

            if (model.equals(oldModel)) {
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
            T storedModel = models.get(i);

            if (storedModel.equals(model)) {
                models.remove(i);
                saveAll(models);
                return;
            }
        }
        System.out.println(model.getClass().getName() + " not found for delete.");
    }

    @Override
    public void saveAll(List<T> models) throws Exception {
        try (FileOutputStream out = new FileOutputStream(this.getFile());
             PrintWriter writer = new PrintWriter(out)) {
            models.forEach(model -> {
                String[] attributes = ToStringParsing.extractAttributes(model.toString());
                String line = attributes[0] + "," + attributes[1] + "," + attributes[2];
                writer.println(line);
            });
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
