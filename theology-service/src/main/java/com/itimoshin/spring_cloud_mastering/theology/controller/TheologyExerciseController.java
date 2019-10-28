package com.itimoshin.spring_cloud_mastering.theology.controller;

import com.itimoshin.spring_cloud_mastering.theology.entity.Exercise;
import com.itimoshin.spring_cloud_mastering.theology.service.ExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/exercise")
public class TheologyExerciseController {

    private final ExerciseService exerciseService;

    public TheologyExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping
    public void add(@RequestBody Exercise exercise) {
       exerciseService.add(exercise);
    }

    @GetMapping
    public List<Exercise> getAll() {
       return exerciseService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        exerciseService.delete(id);
    }
}
