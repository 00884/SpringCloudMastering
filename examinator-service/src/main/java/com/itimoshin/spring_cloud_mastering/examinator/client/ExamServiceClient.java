package com.itimoshin.spring_cloud_mastering.examinator.client;

import com.itimoshin.spring_cloud_mastering.examinator.model.Exercise;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ExamServiceClient {
    List<Exercise> getExercises(@RequestParam("count") int count);
}