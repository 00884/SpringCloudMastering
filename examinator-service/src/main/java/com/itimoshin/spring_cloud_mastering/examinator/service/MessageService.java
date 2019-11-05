package com.itimoshin.spring_cloud_mastering.examinator.service;

import com.itimoshin.spring_cloud_mastering.examinator.model.KafkaDto;
import org.springframework.kafka.annotation.KafkaListener;

public interface MessageService {
    void send(KafkaDto dto);

    void consume(KafkaDto dto);
}
