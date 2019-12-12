package com.itimoshin.spring_cloud_mastering.examinator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itimoshin.spring_cloud_mastering.examinator.model.KafkaDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.SuccessCallback;


@Service
public class MessageServiceImpl implements MessageService {

    private final KafkaTemplate<Long, KafkaDto> kafkaStarshipTemplate;
    private final ObjectMapper objectMapper;
    private final Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);


    @Autowired
    public MessageServiceImpl(KafkaTemplate<Long, KafkaDto> kafkaStarshipTemplate,
                              ObjectMapper objectMapper) {
        this.kafkaStarshipTemplate = kafkaStarshipTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void send(KafkaDto dto) {
        kafkaStarshipTemplate.send("starship", 1L, dto).addCallback(new SuccessCallback<SendResult<Long, KafkaDto>>() {
            @Override
            public void onSuccess(SendResult<Long, KafkaDto> longKafkaDtoSendResult) {
                System.out.println();
            }
        }, new FailureCallback() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println();
            }
        });
    }

    @Override
    @KafkaListener(topics = {"starship"}, containerFactory = "singleFactory")
    public void consume(KafkaDto dto) {
        log.info("=> consumed {}", writeValueAsString(dto));
    }

    @Override
    @KafkaListener(topics = {"starship"}, containerFactory = "singleFactory2")
    public void consume2(KafkaDto dto) {
        log.info("=> consumed {}", writeValueAsString(dto));
    }

    private String writeValueAsString(KafkaDto dto) {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Writing value to JSON failed: " + dto.toString());
        }
    }
}