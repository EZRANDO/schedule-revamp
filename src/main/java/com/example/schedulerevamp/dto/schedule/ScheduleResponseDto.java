package com.example.schedulerevamp.dto.schedule;

import com.example.schedulerevamp.entity.Schedule;
import lombok.Getter;

/**
 * 일정 조회 및 응답에 사용되는 DTO 클래스입니다.
 * <p>
 * 이 클래스는 일정의 ID, 작성자 이름, 제목, 내용을 담고 있으며,
 * 클라이언트에게 응답 데이터를 전달하는 데 사용됩니다.
 */
@Getter
public class ScheduleResponseDto {


    private final long id;


    private final String name;


    private final String scheduleTitle;


    private final String scheduleContent;

    /**
     * {@code ScheduleResponseDto} 생성자.
     *
     * @param id              일정 ID
     * @param name            작성자 이름
     * @param scheduleTitle   일정 제목
     * @param scheduleContent 일정 내용
     */
    public ScheduleResponseDto(Long id, String name, String scheduleTitle, String scheduleContent) {
        this.id = id;
        this.name = name;
        this.scheduleTitle = scheduleTitle;
        this.scheduleContent = scheduleContent;
    }

    /**
     * {@code ScheduleResponseDto} 생성자.
     * @param schedule 응답에 사용할 Schedule 엔티티 객체
     */
    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.scheduleTitle = schedule.getScheduleTitle();
        this.scheduleContent = schedule.getScheduleContent();
        this.name = schedule.getUser().getUsername();
    }
}
