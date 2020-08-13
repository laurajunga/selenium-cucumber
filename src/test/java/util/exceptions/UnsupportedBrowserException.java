package util.exceptions;

public class UnsupportedBrowserException extends Throwable {

    public UnsupportedBrowserException(String message) {
        super(message);
    }

    public UnsupportedBrowserException(String message, Object... msgFormatParams) {
        super(String.format(message, msgFormatParams));
    }

    public UnsupportedBrowserException(Throwable throwable) {
        super(throwable);
    }

    public UnsupportedBrowserException(String s, Throwable throwable) {
        super(s, throwable);
    }
}