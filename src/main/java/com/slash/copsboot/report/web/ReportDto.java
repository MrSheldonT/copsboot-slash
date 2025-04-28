package com.slash.copsboot.report.web;

import com.slash.copsboot.report.Report;
import com.slash.copsboot.report.ReportId;
import com.slash.copsboot.user.UserService;

import java.time.Instant;

public record ReportDto(ReportId id,
                        String reporter,
                        Instant dateTime,
                        String description) {

    public static ReportDto fromReport(Report report, UserService userService) {
        return new ReportDto(report.getId(),
                userService.getUserById(report.getReporterId()).getEmail(),
                report.getDateTime(),
                report.getDescription());
    }
}