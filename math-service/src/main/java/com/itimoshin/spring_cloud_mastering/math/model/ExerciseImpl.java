package com.itimoshin.spring_cloud_mastering.math.model;


import com.itimoshin.spring_cloud_mastering.exam_starter.model.Exercise;

public class ExerciseImpl implements Exercise {

    private final String question;
    private final String answer;

    public ExerciseImpl(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
