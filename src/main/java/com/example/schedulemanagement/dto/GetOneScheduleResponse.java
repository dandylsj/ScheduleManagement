package com.example.schedulemanagement.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetOneScheduleResponse { //조회 기능시 클라이언트에게 보낼 필드 값들

    //속성 Field
    private Long id; //아이디 값
    private String title;//제목 값
    private String content; //내용 값
    private LocalDateTime createAt; //작성일자 값
    private LocalDateTime updateAt; //수정일자 값
    private String userName; //작성자명 값

    //생성자 Constructor
    public GetOneScheduleResponse(Long id, String title, String content, LocalDateTime createAt, LocalDateTime updateAt, String userName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.userName = userName;
    }

}
