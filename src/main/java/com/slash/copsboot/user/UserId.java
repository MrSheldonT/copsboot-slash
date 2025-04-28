package com.slash.copsboot.user;

import com.slash.orm.jpa.AbstractEntityId;

import java.util.UUID;

public class UserId  extends AbstractEntityId<UUID> {

    protected UserId() {
    }

    public UserId(UUID id) {
        super(id);
    }

}
