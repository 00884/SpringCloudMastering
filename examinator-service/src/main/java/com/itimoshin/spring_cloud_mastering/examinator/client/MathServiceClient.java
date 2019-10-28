package com.itimoshin.spring_cloud_mastering.examinator.client;

import com.itimoshin.spring_cloud_mastering.examinator.model.Exercise;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "math-service")
public interface MathServiceClient extends ExamServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "exercise/random")
    List<Exercise> getExercises(@RequestParam("count") int count);
}