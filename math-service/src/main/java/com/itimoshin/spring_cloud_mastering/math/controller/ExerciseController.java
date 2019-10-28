package com.itimoshin.spring_cloud_mastering.math.controller;

import com.itimoshin.spring_cloud_mastering.math.model.Exercise;
import com.itimoshin.spring_cloud_mastering.math.service.ExerciseService;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;
    private final DiscoveryClient discoveryClient;
    public ExerciseController(ExerciseService exerciseService, DiscoveryClient discoveryClient) {
        this.exerciseService = exerciseService;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/random")
    public List<Exercise> random(@RequestParam int count) {
        return exerciseService.random(count);
    }
}
