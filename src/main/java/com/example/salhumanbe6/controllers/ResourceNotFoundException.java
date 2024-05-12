package com.example.salhumanbe6.controllers;

public class ResourceNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    private Long resourceId;

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(Long resourceId) {
        super();
        this.resourceId = resourceId;
    }

    @Override
    public String getMessage() {
        if (resourceId != null)
            return "Element with id '" + resourceId + "' not found";
        return super.getMessage();
    }
}
