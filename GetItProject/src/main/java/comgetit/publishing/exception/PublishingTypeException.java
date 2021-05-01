package comgetit.publishing.exception;

import comgetit.exception.GetItException;

public class PublishingTypeException extends GetItException {

    private static final String MESSAGE = "The %s is not a type publishing";

    public PublishingTypeException(String typePublishing) {
        super(String.format(MESSAGE, typePublishing));
    }
}
