package com.slash.copsboot.infraestructure.mvc;

public record FieldErrorResponse(String fieldName, String errorMessage) {
}