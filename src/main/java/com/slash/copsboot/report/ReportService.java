package com.slash.copsboot.report;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ReportService {
    private final ReportRepository repository;

    public ReportService(ReportRepository repository) {
        this.repository = repository;
    }

    public Report createReport(CreateReportParameters parameters) {
        return repository.save(new Report(repository.nextId(),
                parameters.userId(),
                parameters.dateTime(),
                parameters.description()));
    }
}