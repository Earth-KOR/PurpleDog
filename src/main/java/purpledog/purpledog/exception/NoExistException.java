package purpledog.purpledog.exception;

public class NoExistException extends RuntimeException{

    public NoExistException() {
        super();
    }

    public NoExistException(String message) {
        super(message);
    }

    public NoExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoExistException(Throwable cause) {
        super(cause);
    }

    protected NoExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
