package com.itimoshin.spring_cloud_mastering.math.controller;

import com.itimoshin.spring_cloud_mastering.math.model.Exercise;
import com.itimoshin.spring_cloud_mastering.math.service.ExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
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

    @GetMapping("/random")
    public List<Exercise> random(@RequestParam int count) {
        return exerciseService.random(count);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        exerciseService.delete(id);
    }
}
