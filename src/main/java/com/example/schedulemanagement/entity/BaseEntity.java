package com.example.schedulemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)  //JPA Auditing 활성화 기능
public abstract class BaseEntity {

    //JPA Auditing
    @CreatedDate //생성일
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private String createAt;

    @LastModifiedDate  //수정일
    @Temporal(TemporalType.TIMESTAMP)
    private String updateAt;
}
