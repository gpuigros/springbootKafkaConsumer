package com.puigros.service;

import com.puigros.core.messaging.kafka.KafkaChannelsConstants;
import com.puigros.dto.TestDTO;
import org.json.simple.JSONObject;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

/**
 * Created by gpuigros on 21/08/17.
 */
public interface KafkaMessaging {


    /*
         * (non-Javadoc)
         *
         * @see com.hotelbeds.commonbookingblservice.core.kafka.service.KafkaService#process(org.springframework.messaging.Message)
         */
    @StreamListener(KafkaChannelsConstants.INPUT_HOTELS)
    void process(Message<JSONObject> message);
}
