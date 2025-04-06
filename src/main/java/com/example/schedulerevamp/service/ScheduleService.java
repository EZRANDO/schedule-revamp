package com.example.schedulerevamp.service;

import com.example.schedulerevamp.dto.schedule.ScheduleResponseDto;
import com.example.schedulerevamp.entity.Schedule;
import com.example.schedulerevamp.entity.User;
import com.example.schedulerevamp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;


/**
 * 일정 관련 비즈니스 로직을 담당하는 서비스 클래스입니다.
 * <p>
 * 일정 생성, 조회, 수정, 삭제 기능을 제공합니다.
 */
@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    /**
     * 일정을 저장하고 ScheduleResponseDto로 반환
     *
     * @param user             로그인한 사용자
     * @param scheduleTitle    일정 제목
     * @param scheduleContent  일정 내용
     * @return 생성된 일정의 응답 DTO
     */
    public ScheduleResponseDto save(User user, String scheduleTitle, String scheduleContent) {
        Schedule schedule = new Schedule();
        schedule.setUser(user);
        schedule.setName(user.getUsername());
        schedule.setScheduleTitle(scheduleTitle);
        schedule.setScheduleContent(scheduleContent);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule);
    }

    /**
     * ID로 단일 일정을 조회
     *
     * @param id 일정 ID
     * @return 일정 응답 DTO
     */
    public ScheduleResponseDto findSchedule(Long id) {
        Schedule findSchedule = scheduleRepository.findScheduleByidOrElseThrow(id);
        return new ScheduleResponseDto(
                findSchedule.getId(),
                findSchedule.getName(),
                findSchedule.getScheduleTitle(),
                findSchedule.getScheduleContent()
        );
    }

    /**
     * 일정 제목과 내용 수정
     * 작성자명이 일치해야 수정 가능
     *
     * @param id              일정 ID
     * @param name            작성자명 (검증용)
     * @param scheduleTitle   새로운 제목
     * @param scheduleContent 새로운 내용
     * @return 수정된 일정 응답 DTO
     */
    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, String name, String scheduleTitle, String scheduleContent) {
        Schedule findSchedule = scheduleRepository.findScheduleByidOrElseThrow(id);
        if (!findSchedule.getName().equals(name)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "name not match");
        }
        findSchedule.update(name, scheduleTitle, scheduleContent);
        return new ScheduleResponseDto(findSchedule.getId(), name, scheduleTitle, scheduleContent);
    }

    /**
     * ID로 일정 삭제
     *
     * @param id 삭제할 일정 ID
     */
    public void deleteSchedule(Long id) {
        scheduleRepository.findScheduleByidOrElseThrow(id);
        scheduleRepository.deleteById(id);
    }
}
