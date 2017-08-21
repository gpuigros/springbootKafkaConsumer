package com.puigros.ws.controller;

import com.puigros.dto.TestDTO;
import com.puigros.service.KafkaMessaging;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This is a sample rest controller class.
 * <p>
 * <p>

 * @since JDK1.8
 */
@Slf4j
@RestController
@RequestMapping(value = "/kafka/1.0/")
@Api(value="Example System")
public class KafkaRestController {

    @Autowired
    private KafkaMessaging service;

   //Nothing to do here
    //PoC porpouses



}
