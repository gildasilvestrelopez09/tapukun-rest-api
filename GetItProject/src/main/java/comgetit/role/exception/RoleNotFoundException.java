package comgetit.role.exception;

import comgetit.exception.NotFoundException;

public class RoleNotFoundException extends NotFoundException {

    private static final String MESSAGE = "The %s role doesn\'t exist";

    public RoleNotFoundException(String role) {
        super(String.format(MESSAGE, role));
    }
}