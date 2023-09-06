
package org.classJump.Exceptions;

import java.util.NoSuchElementException;

public class LectureNotFoundException extends NoSuchElementException {

    public LectureNotFoundException(String massage) {
        super(massage);
    }

    public LectureNotFoundException() {
        super("Lecture Not Found!");
    }
}
