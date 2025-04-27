package com.slash.copsboot.user;

import jakarta.persistence.Embeddable;
import org.springframework.util.Assert;

import java.util.UUID;
//@Embeddable // esto no está originalmente
public record AuthServerId(UUID value) {
    public AuthServerId {
        Assert.notNull(value, "The AuthServerId value should not be null");
    }
}
