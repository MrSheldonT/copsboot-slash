package com.slash.copsboot.report.web;

import com.slash.copsboot.report.CreateReportParameters;
import com.slash.copsboot.user.UserId;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;

public record CreateReportRequest(Instant dateTime, @NotBlank String description) {
    public CreateReportParameters toParameters(UserId userId) {
        return new CreateReportParameters(userId, dateTime, description);
    }
}