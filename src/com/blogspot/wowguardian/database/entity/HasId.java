package com.blogspot.wowguardian.database.entity;

import java.math.BigInteger;

/**
 * Represents an entity with ID.
 * Created by User on 20.07.2014.
 */
public interface HasId {
    BigInteger getId();
    void setId(BigInteger id);
}
