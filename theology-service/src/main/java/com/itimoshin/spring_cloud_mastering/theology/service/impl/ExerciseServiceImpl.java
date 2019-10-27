package com.itimoshin.spring_cloud_mastering.theology.service.impl;

import com.itimoshin.spring_cloud_mastering.theology.dao.ExerciseRepository;
import com.itimoshin.spring_cloud_mastering.theology.entity.Exercise;
import com.itimoshin.spring_cloud_mastering.theology.service.ExerciseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
@Transactional
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public Exercise add(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    @Override
    public void delete(long id) {
        exerciseRepository.deleteById(id);
    }

    @Override
    public List<Exercise> random(int count) {
        List<Exercise> result = exerciseRepository.findAll();
        Collections.shuffle(result);
        return count >= result.size() ? result : result.subList(0, count);
    }

    @Override
    public List<Exercise> getAll() {
        return exerciseRepository.findAll();
    }
}
