package com.hori.instagram_clone_api.user.exception;

import java.util.Map;

public class CreateUserException extends RuntimeException {
    private Map<String, Object> errors;

    public CreateUserException(Map<String, Object> errors, String message) {
        super(message);
        this.errors = errors;
    }

    public Map<String, Object> getErrors() {
        return errors;
    }
}
