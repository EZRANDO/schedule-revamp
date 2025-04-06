package com.example.schedulerevamp.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

/**
 * 일정 수정 요청을 담는 DTO입니다.
 * <p>
 * 일정 수정 시 필요한 사용자 이름, 제목, 내용을 포함합니다.
 * 클라이언트에서 서버로 일정 수정 요청을 보낼 때 사용됩니다.
 */
@Getter
public class UpdateScheduleRequestDto {


    private final String name;


    @JsonProperty("schedule_title")
    @NotBlank(message = "제목을 입력하세요.")
    private final String scheduleTitle;


    @JsonProperty("schedule_content")
    private final String scheduleContent;

    /**
     * {@code UpdateScheduleRequestDto} 생성자.
     *
     * @param name 사용자 이름
     * @param scheduleTitle 일정 제목
     * @param scheduleContent 일정 내용
     */
    public UpdateScheduleRequestDto(String name, String scheduleTitle, String scheduleContent) {
        this.name = name;
        this.scheduleTitle = scheduleTitle;
        this.scheduleContent = scheduleContent;
    }
}
