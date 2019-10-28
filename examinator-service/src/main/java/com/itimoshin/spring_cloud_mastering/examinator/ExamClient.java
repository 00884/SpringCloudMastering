package com.itimoshin.spring_cloud_mastering.examinator;

import com.itimoshin.spring_cloud_mastering.examinator.model.Exercise;
import feign.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ExamClient extends Client {
    @RequestMapping(method = RequestMethod.GET, value = "exercise/random")
    List<Exercise> getStores(@RequestParam("count") int count);
}