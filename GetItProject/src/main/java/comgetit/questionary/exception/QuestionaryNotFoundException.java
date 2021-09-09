package comgetit.questionary.exception;

import comgetit.exception.NotFoundException;

public class QuestionaryNotFoundException extends NotFoundException {

    private static final String MESSAGE = "El questionario no existe";

    public QuestionaryNotFoundException() {
        super(MESSAGE);
    }
}
