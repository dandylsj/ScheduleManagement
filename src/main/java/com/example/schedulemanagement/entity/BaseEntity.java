package com.example.schedulemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)  //JPA Auditing 활성화 기능
public abstract class BaseEntity { //추상클래스 abstract 상속을 통해 BaseEntity는 자식 클래스만 만드는 용 사용

    //JPA Auditing
    @CreatedDate //생성일
    @Column(updatable = false) //업데이트 하지 않는다.
    @Temporal(TemporalType.TIMESTAMP) //date + time 의 timestamp(datetime)
    private LocalDateTime createAt; //작성일자 현재 시간으로 저장

    @LastModifiedDate  //수정일
    @Temporal(TemporalType.TIMESTAMP) //date + time 의 timestamp(datetime)
    private LocalDateTime updateAt; //수정일자 현재 시간으로 저장
}
