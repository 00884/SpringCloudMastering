package com.itimoshin.spring_cloud_mastering.examinator;

import com.itimoshin.spring_cloud_mastering.examinator.model.Exercise;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;


    public ExerciseController(DiscoveryClient discoveryClient, RestTemplate restTemplate) {
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/all-subjects")
    public Map<String, Exercise[]> allSubjectsExercises() {
        Map<String, Exercise[]> result = new HashMap<>();
        for (ExamType value : ExamType.values()) {
            result.put(value.name(), restTemplate.getForEntity( "http://"+ value.serviceName + "/exercise/random?count=5", Exercise[].class, new HashMap<>()).getBody());
        }
        return result;
    }
}
