package org.smart4j.plugin.security.exception;

public class AuthcException extends Exception{
    /**
     * Creates a new AuthcException.
     */
    public AuthcException() {
        super();
    }

    /**
     * Constructs a new AuthcException.
     *
     * @param message the reason for the exception
     */
    public AuthcException(String message) {
        super(message);
    }

    /**
     * Constructs a new AuthcException.
     *
     * @param cause the underlying Throwable that caused this exception to be thrown.
     */
    public AuthcException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new AuthcException.
     *
     * @param message the reason for the exception
     * @param cause   the underlying Throwable that caused this exception to be thrown.
     */
    public AuthcException(String message, Throwable cause) {
        super(message, cause);
    }
}
