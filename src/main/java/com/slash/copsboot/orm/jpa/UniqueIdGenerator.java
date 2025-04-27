package com.slash.copsboot.orm.jpa;

public interface UniqueIdGenerator<T> {
    T getNextUniqueId();
}