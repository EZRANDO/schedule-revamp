package com.example.schedulerevamp.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 로그인 요청 시 이메일과 비밀번호를 전달받는 DTO입니다.
 */
@Getter
@NoArgsConstructor(force = true)
public class LoginRequestDto {

    @NotBlank(message = "이메일을 입력해주세요.")
    private final String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private final String password;
}