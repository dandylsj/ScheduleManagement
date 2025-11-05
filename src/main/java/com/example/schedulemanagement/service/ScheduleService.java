package com.example.schedulemanagement.service;


import com.example.schedulemanagement.dto.CreateScheduleRequest;
import com.example.schedulemanagement.dto.CreateScheduleResponse;
import com.example.schedulemanagement.dto.GetOneScheduleResponse;
import com.example.schedulemanagement.entity.Schedule;
import com.example.schedulemanagement.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScheduleService {
    //속성 Field
    private final ScheduleRepository scheduleRepository;

    //생성자 Constructor

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    //기능 Method

    //일정 생성
    @Transactional //트렌잭션 시작
    public CreateScheduleResponse save(CreateScheduleRequest request) {
        //메서드가 종료되면 CreateScheduleRequest 필드의 데이터를  CreateScheduleResponse 로 저장한다.
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
    //조회 기능
    @Transactional(readOnly = true)
    public GetOneScheduleResponse getOne(Long userId) { // . 박스까는거
        Schedule user = scheduleRepository.findById(userId).orElseThrow( //Throw - 예외를 발생시킨다.
                () -> new IllegalStateException("없는 유저입니다.")
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

}
