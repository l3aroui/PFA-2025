package ma.emsi.clientreviewsservice.exceptions;

public class InvalidQuestionTypeException extends RuntimeException{
    public InvalidQuestionTypeException() {
        super("question type text don't have choices");
    }
}
