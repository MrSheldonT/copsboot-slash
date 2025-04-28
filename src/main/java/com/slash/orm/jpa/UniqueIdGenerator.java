package com.slash.orm.jpa;

public interface UniqueIdGenerator<T> {
    T getNextUniqueId();
}