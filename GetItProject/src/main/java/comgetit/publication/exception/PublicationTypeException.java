package comgetit.publication.exception;

import comgetit.exception.GetItException;

public class PublicationTypeException extends GetItException {

    private static final String MESSAGE = "The %s is not a type publication";

    public PublicationTypeException(String typePublication) {
        super(String.format(MESSAGE, typePublication));
    }
}
