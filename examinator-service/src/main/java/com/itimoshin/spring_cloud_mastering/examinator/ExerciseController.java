package com.itimoshin.spring_cloud_mastering.examinator;

import com.itimoshin.spring_cloud_mastering.examinator.model.Exercise;
import feign.Feign;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
    private final RestTemplate restTemplate;
    private final String examinatorMessage;


    public ExerciseController(DiscoveryClient discoveryClient, RestTemplate restTemplate,
                              @Value("${examinator.message}") String examinatorMessage) {
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
        this.examinatorMessage = examinatorMessage;
    }

    @GetMapping("/all-subjects")
    public Map<String, Exercise[]> allSubjectsExercises() {
        System.out.println(examinatorMessage);
        Feign.builder().target(ExamClient.class, "");
        Map<String, Exercise[]> result = new HashMap<>();
        for (ExamType value : ExamType.values()) {
            result.put(value.name(), restTemplate.getForEntity( "http://"+ value.serviceName + "/exercise/random?count=5", Exercise[].class, new HashMap<>()).getBody());
        }
        return result;
    }
}
