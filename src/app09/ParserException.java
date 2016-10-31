package app09;

/**
 * Created by danila on 29.10.2016.
 */
public class ParserException extends Exception {

    private String errorString;

    ParserException(String message) {
        errorString = message;
    }

    @Override
    public String toString() {
        return errorString;
    }
}
