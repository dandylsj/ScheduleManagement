package com.example.schedulemanagement.dto;

import lombok.Getter;

@Getter
public class UpdateScheduleRequest {

    //속성
    private Long id; //아이디 값
    private String title; //제목 값
    private String content; //내용 값
    private String password; //패스워드 값


}
