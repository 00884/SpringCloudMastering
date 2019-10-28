package com.itimoshin.spring_cloud_mastering.exam_starter.controller;

import com.itimoshin.spring_cloud_mastering.exam_starter.model.Exercise;
import com.itimoshin.spring_cloud_mastering.exam_starter.service.ExerciseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/random")
    public <T extends Exercise> List<T> random(@RequestParam int count) {
        return exerciseService.random(count);
    }
}
