package com.itimoshin.spring_cloud_mastering.examinator.model;

public class KafkaDto {
    private String data;

    public KafkaDto(String data) {
        this.data = data;
    }

    public KafkaDto() {
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
