package org.smart4j.plugin.security.exception;

import org.apache.shiro.ShiroException;

public class AuthzException extends ShiroException{
    /**
     * Creates a new AuthcException.
     */
    public AuthzException() {
        super();
    }

    /**
     * Constructs a new AuthcException.
     *
     * @param message the reason for the exception
     */
    public AuthzException(String message) {
        super(message);
    }

    /**
     * Constructs a new AuthcException.
     *
     * @param cause the underlying Throwable that caused this exception to be thrown.
     */
    public AuthzException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new AuthcException.
     *
     * @param message the reason for the exception
     * @param cause   the underlying Throwable that caused this exception to be thrown.
     */
    public AuthzException(String message, Throwable cause) {
        super(message, cause);
    }
}
