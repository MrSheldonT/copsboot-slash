package com.slash.copsboot.user;

import com.slash.copsboot.orm.jpa.AbstractEntityId;

import java.util.UUID;

public class UserId  extends AbstractEntityId<UUID> {

    protected UserId() {
    }

    public UserId(UUID id) {
        super(id);
    }

}
