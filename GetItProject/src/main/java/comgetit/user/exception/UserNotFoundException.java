package comgetit.user.exception;

import comgetit.exception.NotFoundException;

public class UserNotFoundException extends NotFoundException {

    private static final String MESSAGE = "The user doesn\'t exist";

    public UserNotFoundException() {
        super(MESSAGE);
    }
}
