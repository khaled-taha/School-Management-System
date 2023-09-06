package org.classJump;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.classJump.models.Teacher;

public class Main {

    public static void main(String[] args) {

        FileOperations operations = new FileOperations("users.txt");

        ClassJump jump = new ClassJump(operations);


           jump.registerTeacher("khaled","email" ,"123" );
           jump.registerTeacher("khaledtaha","email123" ,"1234" );
            
           List<Teacher> teachers = operations.getAll();
          teachers.forEach(teacher -> {
              System.out.println(teacher.getName());
          });
            
        
        
        

//        try ( FileOutputStream fos = new FileOutputStream("file1.txt", true)) {
//            writeToFile(fos, "\nKhaled Taha");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        try ( FileInputStream input = new FileInputStream("file1.txt")) {
//            byte[] array = readFile(input);
//            System.out.println(new String(array));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }



    }

    public static byte[] readFile(FileInputStream input) throws IOException {
        int numOfBytes = input.available();
        byte[] array = new byte[numOfBytes];
        System.out.println("Available bytes in the file: " + input.available());

        // Read byte from the input stream
        input.read(array);
        System.out.println("Data read from the file: ");
        return array;
    }

    public static boolean writeToFile(FileOutputStream out, String line) throws IOException {
        byte[] dataBytes = line.getBytes();

        // Writes data to the output stream
        out.write(dataBytes);
        System.out.println("Data is written to the file.");
        return true;
    }

    public static boolean readFile(File file) throws FileNotFoundException, IOException {
        FileReader reader = new FileReader(file);
        String text = "";
        int character;

        while ((character = reader.read()) != -1) {
            text += (char) character;
        }

        System.out.println(text);

        return true;
    }

    public static boolean writeToFile(File file, String line) throws IOException {
        try ( FileWriter writer = new FileWriter(file)) { // try-with-resources
            writer.write(line);
        }
        return true;
    }

}
