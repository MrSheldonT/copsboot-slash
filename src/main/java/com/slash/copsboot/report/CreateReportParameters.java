package com.slash.copsboot.report;

import com.slash.copsboot.user.UserId;

import java.time.Instant;

public record CreateReportParameters(UserId userId, Instant dateTime, String description) {
}