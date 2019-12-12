package com.itimoshin.spring_cloud_mastering.examinator.controller;

import com.itimoshin.spring_cloud_mastering.common.ExamType;
import com.itimoshin.spring_cloud_mastering.examinator.client.ExamServiceClient;
import com.itimoshin.spring_cloud_mastering.examinator.client.MathServiceClient;
import com.itimoshin.spring_cloud_mastering.examinator.client.TheologyServiceClient;
import com.itimoshin.spring_cloud_mastering.examinator.model.Exercise;
import com.itimoshin.spring_cloud_mastering.examinator.model.KafkaDto;
import com.itimoshin.spring_cloud_mastering.examinator.service.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/exercise")
@RefreshScope
public class ExerciseController {

    private final DiscoveryClient discoveryClient;
    private final String examinatorMessage;
    private final Map<ExamType, ExamServiceClient> examClientMap;
    private final ApplicationContext applicationContext;
    private final MessageService messageService;


    public ExerciseController(DiscoveryClient discoveryClient, RestTemplate restTemplate,
                              @Value("${examinator.message}") String examinatorMessage,
                              TheologyServiceClient theologyServiceClient,
                              MathServiceClient mathServiceClient, ApplicationContext applicationContext, MessageService messageService) {
        this.discoveryClient = discoveryClient;
        this.examinatorMessage = examinatorMessage;
        this.applicationContext = applicationContext;
        this.messageService = messageService;

        Map<ExamType, ExamServiceClient> examServiceClientMap = new HashMap<>();
        examServiceClientMap.put(ExamType.THEOLOGY, theologyServiceClient);
        examServiceClientMap.put(ExamType.MATH, mathServiceClient);
        this.examClientMap = Collections.unmodifiableMap(examServiceClientMap);
    }

    @GetMapping("/all-subjects")
    public Map<String, List<Exercise>> allSubjectsExercises() {
        Map<String, List<Exercise>> result = new HashMap<>();
        for (ExamType value : ExamType.values()) {
            result.put(value.name(), examClientMap.get(value).getExercises(5));
        }
        return result;
    }

    @GetMapping("send-message")
    public void sendMessage() {
        messageService.send(new KafkaDto(new Date().toString()));
    }
}
