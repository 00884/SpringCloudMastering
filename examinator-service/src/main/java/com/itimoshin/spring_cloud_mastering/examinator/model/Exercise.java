package com.itimoshin.spring_cloud_mastering.examinator.model;

public class Exercise {
    private final String question;
    private final String answer;

    public Exercise(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
