package com.slash.copsboot.orm.jpa;

import com.google.common.base.Objects;
import com.slash.copsboot.util.ArtifactForFramework;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity<T extends EntityId> implements Entity<T> {
    @EmbeddedId
    private T id;

    @ArtifactForFramework
    protected AbstractEntity(){

    }

    public AbstractEntity(T id){
        this.id = checkNotNull(id);
    }

    @Override
    public T getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;

        if(this == o) result = true;
        else if(o instanceof AbstractEntity){
            AbstractEntity other = (AbstractEntity) o;
            result = Objects.equal(id, other.id);
        }
        return result;

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return toStringHelper(this).add("id", id).toString();
    }
}
