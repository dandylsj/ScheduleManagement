package com.example.schedulemanagement.service;


import com.example.schedulemanagement.dto.*;
import com.example.schedulemanagement.entity.Schedule;
import com.example.schedulemanagement.repository.ScheduleRepository;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ScheduleService {
    //속성 Field
    private final ScheduleRepository scheduleRepository; //스케줄 레포지토리를 주입 받아서 만들어짐

    //생성자 Constructor

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    //기능 Method

    //일정 생성
    @Transactional //트렌잭션 시작
    public CreateScheduleResponse save(CreateScheduleRequest request) {//메서드가 종료되면 CreateScheduleRequest 필드의 데이터를  CreateScheduleResponse 로 저장한다.
        Schedule schedule = new Schedule( //새로운 스케줄을 생성하여 저장한다.
                request.getTitle(),
                request.getContent(),
                request.getUserName(),
                request.getPassword()
        );
        // 스캐줄 엔티티의 객체를 데이터 베이스에 저장한다.
        Schedule saveSchedule = scheduleRepository.save(schedule);

        return new CreateScheduleResponse( //박스를 만들어서 넘겨준다. //메서드의 결과가 리턴타입이 된다.
                saveSchedule.getId(),
                saveSchedule.getTitle(),
                saveSchedule.getContent(),
                saveSchedule.getCreateAt(),
                saveSchedule.getUpdateAt(),
                saveSchedule.getUserName()
        );
    }
    //단건 조회 기능
    @Transactional(readOnly = true) //읽기만 가능한
    public GetOneScheduleResponse getOne(String userName) { // . 박스까는거
        Schedule user = scheduleRepository.findByUserName(userName).orElseThrow( //작성자명이 레포지토리에서 찾았을때 값을 찾는다. 있으면 넘어가고
                () -> new IllegalStateException("없는 유저입니다.")//없으면 orElseThrow - 예외를 발생시킨다.
        );
        return new GetOneScheduleResponse(  //박스를 만들어서 넘겨준다. //메서드의 결과가 리턴타입이 된다.
                user.getId(),
                user.getTitle(),
                user.getContent(),
                user.getCreateAt(),
                user.getUpdateAt(),
                user.getUserName()
        );

    }

    //다건 조회
    @Transactional(readOnly = true) //읽기만 가능
    public List<GetOneScheduleResponse> getAll() {
        List<Schedule> allScheduleList = scheduleRepository.findAllByOrderByCreateAtDesc(); //스케줄 레포지토리의 모든 데이터를 불러와서 리스트화 시키고 내림차순으로 정렬한다.

        List<GetOneScheduleResponse> dtos = new ArrayList<>(); //리스트를 초기화 시킨다.
        for (Schedule dto : allScheduleList) {  // 레포지토리의 모든 데이터를 아래의 값들과 불러와 리스트의 최대치까지 반복한다.
            dtos.add(new GetOneScheduleResponse(
                    dto.getId(),
                    dto.getTitle(),
                    dto.getContent(),
                    dto.getCreateAt(),
                    dto.getUpdateAt(),
                    dto.getUserName()
            ));
        }
        return dtos; //반복한 리스트를 반환한다.
    }

    //수정 기능
    @Transactional
    public UpdateScheduleResponse update(Long id, UpdateScheduleRequest request) { //아이디 값과 리퀘스트 받은 바디의 값
        Schedule schedule = scheduleRepository.findById(id).orElseThrow( //레포지토리의 아이디를 찾아보고 아이디 값이 있으면 넘어가고
                () -> new IllegalStateException("없는 유저입니다.")//없으면 orElseThrow - 예외를 발생시킨다.
        );
        schedule.update(  //수정할 제목과 내용
                request.getTitle(),
                request.getContent()
        );
        return new UpdateScheduleResponse( //제목과 내용을 수정하고 수정한 현재시간을 함께 리턴한다.
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getUpdateAt()
        );

    }
    //삭제 기능
    @Transactional
    public void delete(Long id, DeleteScheduleRequest request) { //아이디 값과 리퀘스트 받은 바디의 값
        // 1. 삭제할 일정이 DB에 존재하는지 확인
        Schedule schedule = scheduleRepository.findById(id).orElseThrow( //레포지토리의 아이디를 찾아보고 아이디 값이 있으면 넘어가고
                () -> new IllegalArgumentException("선택한 일정이 존재하지 않습니다.") //없으면 orElseThrow - 예외를 발생시킨다.
        );
        // 2. 비밀번호 일치 여부 확인
        //System.out.println(schedule.getPassword());  비밀번호가 어떻게 넘어갔는지 확인용 출력
        if (!schedule.getPassword().equals(request.getPassword())) { //리퀘스트 받은 바디의 비밀번호 값이 , 엔티티의 비밀번호 값과 일치하는지 확인한다.
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다."); //일치하지 않으면 예외를 발생시킨다.
        }
        // 3. 일정 삭제
        scheduleRepository.deleteById(id); //레포지토리의 일치하는 아이디 값의 일정을 삭제한다.
    }

}
