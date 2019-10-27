package com.itimoshin.spring_cloud_mastering.examinator;

import com.itimoshin.spring_cloud_mastering.examinator.model.Exercise;
import org.springframework.cloud.netflix.eureka.CloudEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/exercise")
public class ExerciseController {

    private final EurekaDiscoveryClient discoveryClient;

    public ExerciseController(EurekaDiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/all-subjects")
    public List<Exercise> allSubjectsExcercises() {
        discoveryClient.get
    }
}
