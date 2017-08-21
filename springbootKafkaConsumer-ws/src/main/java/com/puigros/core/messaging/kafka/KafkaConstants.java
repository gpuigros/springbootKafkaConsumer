package com.puigros.core.messaging.kafka;

/**
 * Created by gpuigros on 21/08/17.
 * Enum that defines kafka output channels
 */
public enum KafkaConstants {
    ACTION_CODE("actionCode"),
    ENTITY_ID("entityID"),
    ENTITY_NAME("entityName");


    /** The code. */
    private final String code;

    /**
     * Instantiates a new board base segmentType.
     *
     * @param code the code
     */
    KafkaConstants(final String code) {
        this.code = code;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the value.
     *
     * @param code the code
     * @return the value
     */
    public static KafkaConstants getValue(final String code) {
        for (final KafkaConstants v : values()) {
            if (code.equals(v.getCode())) {
                return v;
            }
        }
        return null;
    }
}