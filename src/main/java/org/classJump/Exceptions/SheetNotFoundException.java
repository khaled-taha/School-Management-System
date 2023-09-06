
package org.classJump.Exceptions;

public class SheetNotFoundException extends Exception {

    public SheetNotFoundException(String message) {
        super(message);
    }

    public SheetNotFoundException() {
        super("Sheet Not Found!");
    }
}
