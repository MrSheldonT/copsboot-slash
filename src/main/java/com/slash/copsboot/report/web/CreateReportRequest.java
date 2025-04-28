package com.slash.copsboot.report.web;

import com.slash.copsboot.report.CreateReportParameters;
import com.slash.copsboot.user.UserId;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
@ValidCreateReportRequest
public record CreateReportRequest(Instant dateTime, @ValidReportDescription @NotBlank String description
                                    , boolean trafficIncident
                                    , int numberOfInvolvedCars
                                    , @NotNull MultipartFile image) {

    public CreateReportParameters toParameters(UserId userId) {
        return new CreateReportParameters(userId, dateTime, description);
    }
}