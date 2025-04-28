package com.slash.orm.jpa;

public interface Entity<T extends EntityId> {
    T getId();
}
