package com.puigros.core.messaging.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by gpuigros on 21/08/17.
 */
public interface KafkaChannelsInput {
    String INPUT_SEGMENT = "inputHotelsChannel";

    @Input
    SubscribableChannel inputHotelsChannel();
}
