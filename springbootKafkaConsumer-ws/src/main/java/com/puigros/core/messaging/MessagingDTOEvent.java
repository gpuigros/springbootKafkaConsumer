package com.puigros.core.messaging;


import com.puigros.dto.DTO;
import org.springframework.context.ApplicationEvent;



import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by gpuigros on 21/08/17.
 *  * The Class MessagingDTOEvent.
 *  *
 *  * @param <T> the entity type
 *
 *
 * @param <T> the generic type
 */

/*
 * (non-Javadoc)
 *
 * @see java.util.EventObject#toString()
 */


/*
 * (non-Javadoc)
 *
 * @see java.lang.Object#hashCode()
 */
@EqualsAndHashCode(callSuper = false)
public class MessagingDTOEvent<T extends DTO<?>> extends ApplicationEvent {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;



    /** The id. */
    private String id;


    public MessagingDTOEvent(Object source) {
        super(source);
    }
}