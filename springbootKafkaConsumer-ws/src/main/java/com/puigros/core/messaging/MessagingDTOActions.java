package com.puigros.core.messaging;

/**
 * Created by gpuigros on 21/08/17.
 * Actions published and consumed from kafka
 */
public enum MessagingDTOActions {
    CREATE("create"),
    UPDATE("update"),
    DELETE("delete");


    /** The code. */
    private final String code;

    /**
     * Instantiates a new board base segmentType.
     *
     * @param code the code
     */
    MessagingDTOActions(final String code) {
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
    public static MessagingDTOActions getValue(final String code) {
        for (final MessagingDTOActions v : values()) {
            if (code.equals(v.getCode())) {
                return v;
            }
        }
        return null;
    }

}


