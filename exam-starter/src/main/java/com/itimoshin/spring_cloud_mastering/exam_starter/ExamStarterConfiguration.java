package com.itimoshin.spring_cloud_mastering.exam_starter;

import com.itimoshin.spring_cloud_mastering.exam_starter.controller.ExerciseController;
import com.itimoshin.spring_cloud_mastering.exam_starter.service.ExerciseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExamStarterConfiguration {

    @Bean
    public ExerciseController exerciseController(ExerciseService exerciseService) {
        return new ExerciseController(exerciseService);
    }}
