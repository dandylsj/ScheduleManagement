package com.example.schedulemanagement.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor (access = AccessLevel.PROTECTED)


public class Schedule extends BaseEntity { //BaseEntity 상속하여 날짜를 받는다.
    //속성 Field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //아이디 자동생성
    private Long id; //아이디 값
    @Column(length = 100) //타이틀의 길이
    private String title; //제목
    private String content;  //내용
    private String userName;  //사용자 이름
    private String password;  //비밀번호



    //생성자 Constructor
    public Schedule(String title, String content, String userName,String password) {
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.password = password;

    }
    //기능 Method
}
