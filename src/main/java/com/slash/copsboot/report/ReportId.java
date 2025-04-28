package com.slash.copsboot.report;

import com.slash.copsboot.orm.jpa.AbstractEntityId;
import com.slash.copsboot.util.ArtifactForFramework;

import java.util.UUID;

public class ReportId extends AbstractEntityId<UUID> {

    @ArtifactForFramework
    protected ReportId() {}

    public ReportId(UUID id) {
        super(id);
    }
}
