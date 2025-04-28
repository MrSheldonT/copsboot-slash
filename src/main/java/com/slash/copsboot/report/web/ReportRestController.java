package com.slash.copsboot.report.web;

import com.slash.copsboot.report.CreateReportParameters;
import com.slash.copsboot.report.Report;
import com.slash.copsboot.report.ReportService;
import com.slash.copsboot.user.AuthServerId;
import com.slash.copsboot.user.User;
import com.slash.copsboot.user.UserNotFoundException;
import com.slash.copsboot.user.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/reports")
public class ReportRestController {

    private final ReportService service;
    private final UserService userService;

    public ReportRestController(ReportService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReportDto createReport(@AuthenticationPrincipal Jwt jwt, @Valid @RequestBody CreateReportRequest request) {
        AuthServerId authServerId = new AuthServerId(UUID.fromString(jwt.getSubject()));
        User user = userService.findUserByAuthServerId(authServerId)
                .orElseThrow(() -> new UserNotFoundException(authServerId));
        CreateReportParameters parameters = request.toParameters(user.getId());
        Report report = service.createReport(parameters);
        return ReportDto.fromReport(report, userService);
    }
}

