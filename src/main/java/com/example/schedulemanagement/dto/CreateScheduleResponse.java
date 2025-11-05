package com.example.schedulemanagement.dto;


import lombok.Getter;

@Getter
public class CreateScheduleResponse { //생성 기능시 클라이언트에게 보낼 필드 값들

    //속성 Field
    private Long id;
    private String title;
    private String content;
    private String createAt;
    private String updateAt;
    private String userName;


    //생성자 Constructor
    public CreateScheduleResponse(Long id, String title, String content, String createAt, String updateAt, String userName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.userName = userName;
    }

}
