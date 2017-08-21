package com.puigros.dto;

/**
 * Created by gpuigros on 21/08/17.
 */
import java.io.Serializable;

/**
 * The Interface Identifiable.
 *
 * @param <I> the generic type
 */
public interface Identifiable<I extends Serializable> extends Serializable {
    /**
     * Gets the id.
     *
     * @return the id
     */
    I getId();

    /**
     * Sets the id.
     *
     * @param dto the new id
     */
    void setId(I dto);
}