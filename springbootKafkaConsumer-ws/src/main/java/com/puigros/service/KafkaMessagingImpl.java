package com.puigros.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.puigros.core.messaging.MessagingDTOActions;
import com.puigros.core.messaging.kafka.KafkaChannelsConstants;
import com.puigros.core.messaging.kafka.KafkaChannelsInput;
import com.puigros.core.messaging.kafka.KafkaMessageProcessor;
import com.puigros.dto.TestDTO;
import lombok.extern.log4j.Log4j2;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by gpuigros on 21/08/17.
 */
@Service("KafkaMessaging")
@Log4j2
@EnableBinding(KafkaChannelsInput.class)
public class KafkaMessagingImpl implements KafkaMessaging {
    /** The kafka message processor. */
    @Autowired
    private KafkaMessageProcessor kafkaMessageProcessor;

    /*
     * (non-Javadoc)
     *
     * @see com.hotelbeds.commonbookingblservice.core.kafka.service.KafkaService#process(org.springframework.messaging.Message)
     */
    @StreamListener(KafkaChannelsConstants.INPUT_HOTELS)
    @Override
    public void process(final Message<org.json.simple.JSONObject> message) {

        final MessagingDTOActions action = kafkaMessageProcessor.getAction(message);

        //in case of need transformation
        TestDTO obj=null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            obj= objectMapper.readValue(message.getPayload().toString(), TestDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //in case of need transformation
        switch (action) {
            case DELETE:
                processDeleteMessage(message);
                break;
            case UPDATE:
                processUpdateMessage(message);
                break;
            case CREATE:
                processCreateMessage(message);
                break;
            default:
                break;
        }

    }

    /**
     * Process delete message.
     *
     * @param message the message
     */
    private void processDeleteMessage(final Message<JSONObject> message) {
        log(MessagingDTOActions.DELETE, delete(message));
    }

    /**
     * Delete.
     *
     * @param message the message
     * @return the JSON object
     */
    private JSONObject delete(final Message<JSONObject> message) {
        final org.json.simple.JSONObject jsonObject = processMessage(message);
        log(MessagingDTOActions.UPDATE, upsert(message));
        return jsonObject;
    }

    /**
     * Process update message.
     *
     * @param message the message
     */
    private void processUpdateMessage(final Message<JSONObject> message) {
        log(MessagingDTOActions.UPDATE, upsert(message));
    }

    /**
     * Process create message.
     *
     * @param message the message
     */
    private void processCreateMessage(final Message<JSONObject> message) {
        log(MessagingDTOActions.CREATE, upsert(message));
    }

    /**
     * Upsert.
     *
     * @param message the message
     * @return the JSON object
     */
    private JSONObject upsert(final Message<JSONObject> message) {
        final org.json.simple.JSONObject jsonObject = processMessage(message);
        log(MessagingDTOActions.UPDATE, upsert(message));
        return jsonObject;
    }

    /**
     * Log.
     *
     * @param action the action
     * @param jsonObject the json object
     */
    private void log(final MessagingDTOActions action, final JSONObject jsonObject) {
            log.debug("[KAFKA] Processed Action [], Object {} ", action, jsonObject);
    }



    /**
     * Process message.
     *
     * @param message the message
     * @return the org.json.simple. json object
     */
    private org.json.simple.JSONObject processMessage(final Message<org.json.simple.JSONObject> message) {
        return kafkaMessageProcessor.process(message);
    }


}
