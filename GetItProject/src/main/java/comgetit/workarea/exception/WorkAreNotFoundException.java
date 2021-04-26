package comgetit.workarea.exception;

import comgetit.exception.NotFoundException;

public class WorkAreNotFoundException extends NotFoundException {

    private static final String MESSAGE = "The work area doesn\'t exist";

    public WorkAreNotFoundException() {
        super(MESSAGE);
    }
}
