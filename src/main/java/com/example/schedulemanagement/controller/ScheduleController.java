package com.example.schedulemanagement.controller;

import com.example.schedulemanagement.dto.CreateScheduleRequest;
import com.example.schedulemanagement.dto.CreateScheduleResponse;
import com.example.schedulemanagement.dto.GetOneScheduleResponse;
import com.example.schedulemanagement.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules") // URL 경로
@RequiredArgsConstructor //final 이 붙은 생성자 자동생성
public class ScheduleController {
    //속성 Field
    private final ScheduleService scheduleService;


    //기능 Method

    //일정 생성 컨트롤러
    @PostMapping("/create")  //호출 경로 매핑
    public ResponseEntity<CreateScheduleResponse> create(@RequestBody CreateScheduleRequest request) { //JSON 형태의 데이터로 받는다.
        CreateScheduleResponse result = scheduleService.save(request); // 클라이언트가 보낸 필드를 받아서 저장한다.
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
        // body(result) - 서비스에서 응답받은 결과를 다시 JSON 형태로 변환하여 클라이언트에 전송
        // status(HttpStatus.CREATED) -생성 되었다는것을 CREATED 로 알려줌
    }
    //일정 조회 컨트롤러
    @GetMapping("/{id}")   //호출 경로 매핑 id 값을 넣어서  불러옴
    public ResponseEntity<GetOneScheduleResponse> getOne(@PathVariable Long id) {
        GetOneScheduleResponse result = scheduleService.getOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
