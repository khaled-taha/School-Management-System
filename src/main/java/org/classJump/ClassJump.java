package org.classJump;

import org.classJump.models.Teacher;


public class ClassJump {

   // private ArrayList<Teacher> teachers;
    private FileOperations file;
    public ClassJump(FileOperations file){
        this.file = file;
    }



    public void registerTeacher(String name, String email, String password) {
          //  this.searchTeacher(email);
            this.file.save(new Teacher(name, email, password));
    }



    public boolean loginTeacher(String username, String password){
            Teacher teacher =  this.file.findTeacher(username, password);
            if(teacher != null) return true;
            return false;
    }
    /*

    private void searchTeacher(String email) throws NoSuchElementException {
        for (Teacher teacher : this.teachers) {
            if (teacher.getEmail().isEmpty() && teacher.getEmail().equals(email)) {
                throw new NoSuchElementException("Duplicated Email: " + teacher.getEmail());
            }
        }
    }

    private void searchTeacher(String username, String password) throws NoSuchElementException {
        for (Teacher teacher : this.teachers) {
            if (teacher.getName().equalsIgnoreCase(username) && teacher.getPassWord().equals(password)) {
                throw new NoSuchElementException("Teacher Found: " + username);
            }
        }
    }
*/
}
