package ma.emsi.clientreviewsservice.exceptions;

public class InvalidQuestionTypeException extends RuntimeException{
    public InvalidQuestionTypeException(String message) {
        super("question type text don't have choices");
    }
}
