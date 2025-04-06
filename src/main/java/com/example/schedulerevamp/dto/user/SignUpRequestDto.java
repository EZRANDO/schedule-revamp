package com.example.schedulerevamp.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 회원 가입 요청을 위한 DTO입니다.
 * <p>
 * 사용자명, 이메일, 비밀번호 정보를 포함하며,
 * 클라이언트가 서버로 회원 가입 요청을 보낼 때 사용됩니다.
 */
@Getter
@NoArgsConstructor(force = true)
public class SignUpRequestDto {


    @NotBlank(message = "이름은 필수 입력값 입니다.")
    private final String username;


    @NotBlank(message = "이메일은 필수 입력값 입니다.")
    private final String email;


    @NotBlank(message = "비밀번호는 필수 입력값 입니다.")
    @Size(min = 8, max = 20 ,message = "비밀번호 설정은 8자 이상 20자 이하입니다.")
    private final String password;


}
