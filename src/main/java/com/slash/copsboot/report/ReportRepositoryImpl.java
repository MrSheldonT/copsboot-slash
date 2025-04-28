package com.slash.copsboot.report;

import com.slash.orm.jpa.UniqueIdGenerator;

import java.util.UUID;

public class ReportRepositoryImpl implements ReportRepositoryCustom {

    private final UniqueIdGenerator<UUID> generator;

    public ReportRepositoryImpl(UniqueIdGenerator<UUID> generator) {
        this.generator = generator;
    }

    @Override
    public ReportId nextId() {
        return new ReportId(generator.getNextUniqueId());
    }

}