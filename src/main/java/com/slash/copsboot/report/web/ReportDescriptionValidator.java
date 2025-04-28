package com.slash.copsboot.report.web;

import jakarta.validation.*;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.time.Instant;
import java.util.Set;



public class ReportDescriptionValidator implements ConstraintValidator<ValidReportDescription, String> { //<1>

    @Override
    public void initialize(ValidReportDescription constraintAnnotation) { //<2>
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean result = true;
        if (!value.toLowerCase().contains("suspect")) { //<3>
            result = false;
        }
        return result;
    }
}