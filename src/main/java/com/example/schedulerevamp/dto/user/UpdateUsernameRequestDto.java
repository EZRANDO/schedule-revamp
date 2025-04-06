package com.example.schedulerevamp.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 사용자 이름 및 이메일 수정 요청을 위한 DTO입니다.
 * <p>
 * 기존 사용자 정보와 수정할 이메일(newEmail)을 포함합니다.
 */
@Getter
@NoArgsConstructor(force = true)
public class UpdateUsernameRequestDto {


    @NotBlank
    private final String newPassword;

    private final String password;


}
