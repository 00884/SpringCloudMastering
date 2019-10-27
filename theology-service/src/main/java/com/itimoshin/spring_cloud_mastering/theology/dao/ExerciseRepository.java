package com.itimoshin.spring_cloud_mastering.theology.dao;

import com.itimoshin.spring_cloud_mastering.theology.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

/*    @Query(value = "select * from exercise e order by rand() limit :count", nativeQuery = true)
    List<Exercise> random(@Param("limit") int count);*/
}
