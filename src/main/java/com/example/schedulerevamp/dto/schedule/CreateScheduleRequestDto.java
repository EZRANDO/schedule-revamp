package com.example.schedulerevamp.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

/**
 * 일정 생성 요청을 담는 DTO입니다.
 * <p>
 * 사용자 이름, 일정 제목, 일정 내용을 포함하며,
 * 클라이언트에서 서버로 일정을 생성할 때 사용됩니다.
 */
@Getter
public class CreateScheduleRequestDto {



    @JsonProperty("schedule_title")
    @NotBlank(message = "제목을 입력하세요.")
    private final String scheduleTitle;


    @JsonProperty("schedule_content")
    private final String scheduleContent;

    /**
     * {@code CreateScheduleRequestDto} 생성자.
     *
     * @param name 사용자 이름
     * @param scheduleTitle 일정 제목
     * @param scheduleContent 일정 내용
     */
    public CreateScheduleRequestDto(String name, String scheduleTitle, String scheduleContent) {
   //     this.name = name;
        this.scheduleTitle = scheduleTitle;
        this.scheduleContent = scheduleContent;
    }
}
