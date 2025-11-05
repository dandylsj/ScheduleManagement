package com.example.schedulemanagement.repository;

import com.example.schedulemanagement.dto.GetOneScheduleResponse;
import com.example.schedulemanagement.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Component
public interface ScheduleRepository extends JpaRepository<Schedule, Long> { //

    Optional<Schedule> findByUserName(String userName); //단건 조회시 작성자명이 있는지 없는지 체크

    List<Schedule> findAll(); //모든 값을 불러오는 기능

    List<Schedule> findAllByOrderByCreateAtDesc(); //다 건 조회시 내림차순으로 정렬


}
