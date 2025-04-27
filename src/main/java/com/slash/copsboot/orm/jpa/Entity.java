package com.slash.copsboot.orm.jpa;

import java.io.Serializable;

public interface Entity<T extends EntityId> {
    T getId();
}
