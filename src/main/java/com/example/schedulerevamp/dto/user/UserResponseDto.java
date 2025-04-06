package com.example.schedulerevamp.dto.user;

import lombok.Getter;

/**
 * 사용자 정보 응답에 사용되는 DTO입니다.
 * <p>
 * 사용자 이름과 이메일 정보를 포함하며,
 * 사용자 조회 이후 사용자 정보를 반환할 때 사용됩니다.
 */
@Getter
public class UserResponseDto {


    private final String username;


    private final String email;

    /**
     * {@code UserResponseDto} 생성자.
     *
     * @param username 사용자 이름
     * @param email 사용자 이메일
     */
    public UserResponseDto(final String username, final String email) {
        this.username = username;
        this.email = email;
    }


}
