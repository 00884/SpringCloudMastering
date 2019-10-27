package com.itimoshin.spring_cloud_mastering.theology.service;

import com.itimoshin.spring_cloud_mastering.theology.entity.Exercise;

import java.util.List;

public interface ExerciseService {

    Exercise add(Exercise exercise);

    void delete(long id);

    List<Exercise> random(int count);

    List<Exercise> getAll();
}

