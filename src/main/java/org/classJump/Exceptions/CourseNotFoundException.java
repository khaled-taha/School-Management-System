
package org.classJump.Exceptions;

public class CourseNotFoundException extends Exception {

    public CourseNotFoundException() {
        super("Course Not Found!");
    }

    public CourseNotFoundException(String message) {
        super(message);
    }

}
