package com.example.schedulemanagement.dto;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleResponse {
    //속성
    private String title; //제목 값
    private String content; //내용 값
    private LocalDateTime updateAt; //수정일 값

    //생성자
    public UpdateScheduleResponse(String title, String content, LocalDateTime updateAt) {
        this.title = title;
        this.content = content;
        this.updateAt = updateAt;
    }
}
