package com.example.schedulerevamp.dto.user;

import lombok.Getter;

/**
 * 회원 가입 응답을 위한 DTO입니다.
 * <p>
 * 회원 가입 완료 후 클라이언트에 반환되는 사용자 정보를 포함합니다.
 * 비밀번호는 포함되지 않습니다.
 */
@Getter
public class SignUpResponseDto {


    private final long id;


    private final String username;


    private final String email;

    /**
     * {@code SignUpResponseDto} 생성자.
     *
     * @param id 생성된 사용자 ID
     * @param username 사용자 이름
     * @param email 사용자 이메일
     */
    public SignUpResponseDto(final long id, final String username, final String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
