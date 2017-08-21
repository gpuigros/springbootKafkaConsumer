package com.puigros.core.messaging.kafka;


import com.puigros.core.messaging.MessagingDTOActions;
import org.json.simple.JSONObject;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class KafkaMessageProcessor.
 * Created by gpuigros on 21/08/17.
 */
@Component
@Slf4j
public class KafkaMessageProcessor {

    /**
     * Process.
     *
     * @param message the message
     * @return the JSON object
     */
    public org.json.simple.JSONObject process(final Message<JSONObject> message) {
        final Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        final JSONObject jsonObject = message.getPayload();
        log.debug("[KAFKA] Received Object {} ", jsonObject);
        if (acknowledgment != null) {
            log.debug("[KAFKA] Acknowledgment provided {}", acknowledgment);
            acknowledgment.acknowledge();
        }
        return jsonObject;
    }

    /**
     * Gets the action.
     *
     * @param message the message
     * @return the action
     */
    public MessagingDTOActions getAction(final Message<JSONObject> message) {
        return MessagingDTOActions.getValue((String) message.getHeaders().get(KafkaConstants.ACTION_CODE.getCode()));
    }

}
