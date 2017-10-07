package com.sultanongarbayev.userswebservice;

/**
 * Custom {@link Exception} object which is thrown whenever user related operations are failed.
 */
public class UserException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Message of the error.
     */
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public UserException() {
        super();
    }

    public UserException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
