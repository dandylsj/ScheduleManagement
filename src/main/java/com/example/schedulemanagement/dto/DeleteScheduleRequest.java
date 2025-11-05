package com.example.schedulemanagement.dto;

import lombok.Getter;

@Getter
public class DeleteScheduleRequest {

    //속성
    private String password; //패스워드

    //생성자
    public DeleteScheduleRequest(String password) {
        this.password = password;
    }

}
