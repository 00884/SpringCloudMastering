package com.itimoshin.spring_cloud_mastering.examinator.service;

import com.itimoshin.spring_cloud_mastering.examinator.model.KafkaDto;

public interface MessageService {
    void send(KafkaDto dto);

    void consume(KafkaDto dto);
    void consume2(KafkaDto dto);

}
