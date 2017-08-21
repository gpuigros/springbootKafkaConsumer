package com.puigros.dto;

/**
 * Created by gpuigros on 21/08/17.
 */
import java.io.Serializable;


/**
 * Instantiates a new entity dto.
 *
 * @param <I> the generic type
 */
public abstract class DTO<I extends Serializable> implements Serializable, Identifiable<I> {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6767998692028533471L;
}

