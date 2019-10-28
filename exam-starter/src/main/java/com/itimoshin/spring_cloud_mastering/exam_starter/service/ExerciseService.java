package com.itimoshin.spring_cloud_mastering.exam_starter.service;

import com.itimoshin.spring_cloud_mastering.exam_starter.model.Exercise;

import java.util.List;

public interface ExerciseService<T extends Exercise> {

    List<T> random(int count);

}

