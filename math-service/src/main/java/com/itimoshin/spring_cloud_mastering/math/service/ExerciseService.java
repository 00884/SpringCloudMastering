package com.itimoshin.spring_cloud_mastering.math.service;

import com.itimoshin.spring_cloud_mastering.math.model.Exercise;

import java.util.List;

public interface ExerciseService {

    List<Exercise> random(int count);

}

