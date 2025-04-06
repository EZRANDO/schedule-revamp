package com.example.schedulerevamp.controller;

import com.example.schedulerevamp.dto.schedule.CreateScheduleRequestDto;
import com.example.schedulerevamp.dto.schedule.ScheduleResponseDto;
import com.example.schedulerevamp.dto.schedule.UpdateScheduleRequestDto;
import com.example.schedulerevamp.entity.User;
import com.example.schedulerevamp.service.ScheduleService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * {@code ScheduleController} 클래스는 일정 관련 HTTP 요청을 처리하는 REST 컨트롤러입니다.
 * <p>
 * 일정 생성, 조회, 수정, 삭제(CRUD) 기능을 제공하며,
 * {@link ScheduleService}를 통해 비즈니스 로직을 위임받아 처리합니다.
 *
 * 이 컨트롤러는 클라이언트로부터 받은 요청을 검증하고,
 * 적절한 서비스 계층 메서드를 호출한 후 결과를 응답 형태로 반환합니다.
 */
@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    /**
     * 새로운 일정 생성.
     *
     * @param requestDto 일정 생성 요청 정보
     * @return 생성된 일정 정보와 201(CREATED) 응답
     */
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(HttpServletRequest request, @RequestBody CreateScheduleRequestDto requestDto) {
        //값들 받기. responseDto 하고 서비스.구현한 메서드, 반환

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("sessionKey");

        ScheduleResponseDto responseDto =
                scheduleService.save(
                        user,
                        requestDto.getScheduleTitle(),
                        requestDto.getScheduleContent()
                );


        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);

    }

    /**
     * 해당하는 ID로 일정 조회.
     *
     * @param id 조회할 일정 ID
     * @return 일정 정보와 200(OK) 응답
     */
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findSchedule(@PathVariable Long id) {
        ScheduleResponseDto scheduleresponseDto = scheduleService.findSchedule(id);

        return new ResponseEntity<>(scheduleresponseDto, HttpStatus.OK);
    }

    /**
     * 해당하는 ID로 일정 수정.
     *
     * @param id 조회할 일정 ID
     * @return 일정 정보와 200(OK) 응답
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody UpdateScheduleRequestDto requestDto) {
        //DB업데이트 해야해서 필요함.
        ScheduleResponseDto scheduleResponseDto =
                scheduleService.updateSchedule(
                        id,
                        requestDto.getName(),
                        requestDto.getScheduleTitle(),
                        requestDto.getScheduleContent());

        return new ResponseEntity<>(HttpStatus.OK);

    }
    /**
     * 해당하는 ID 일정 삭제
     *
     * @param id 삭제할 일정 ID
     * @return 200(OK) 응답
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {

        scheduleService.deleteSchedule(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
