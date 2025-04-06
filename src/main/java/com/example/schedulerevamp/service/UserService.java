package com.example.schedulerevamp.service;


import com.example.schedulerevamp.config.PasswordEncoder;
import com.example.schedulerevamp.dto.user.SignUpResponseDto;
import com.example.schedulerevamp.dto.user.UserResponseDto;
import com.example.schedulerevamp.entity.User;
import com.example.schedulerevamp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

/**
 * 사용자 관련 비즈니스 로직을 담당하는 서비스 클래스입니다.
 * <p>
 * 회원가입, 로그인, 정보 조회, 비밀번호 수정 및 삭제 기능을 제공합니다.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 비밀번호 암호화 후 유저 저장
     *
     * @param username 사용자명
     * @param email    이메일
     * @param password 비밀번호
     * @return 회원가입 응답 DTO
     */
    public SignUpResponseDto signUp(String username, String email, String password) {
        User user = new User(username, email, password);
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);

        User savedUser = userRepository.save(user);
        return new SignUpResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail(), savedUser.getPassword());
    }

    /**
     * 이메일로 사용자 조회 후 비밀번호 검증
     *
     * @param email    이메일
     * @param password 평문 비밀번호
     * @return 로그인 성공 시 User 객체, 실패 시 null
     */
    public User login(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElse(null);
    }

    /**
     * 사용자 ID로 단일 유저 정보 조회
     *
     * @param id 유저 ID
     * @return 사용자 응답 DTO
     */
    public UserResponseDto findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 id입니다.");
        }
        User findUser = optionalUser.get();
        return new UserResponseDto(findUser.getUsername(), findUser.getEmail());
    }

    /**
     * 사용자 비밀번호 변경
     *
     * @param id           사용자 ID
     * @param password     현재 비밀번호
     * @param newPassword  새 비밀번호
     */
    @Transactional
    public void updateUser(Long id, String password, String newPassword) {
        User findUser = userRepository.findByIdOrElseThrow(id);
        if (!passwordEncoder.matches(password, findUser.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다.");
        }
        String encodedNewPassword = passwordEncoder.encode(newPassword);
        findUser.updateUser(encodedNewPassword);
    }

    /**
     * 사용자 삭제 - 비밀번호 검증 후 삭제 처리
     *
     * @param id       사용자 ID
     * @param password 입력한 비밀번호
     */
    public void delete(Long id, String password) {
        User findUser = userRepository.findByIdOrElseThrow(id);
        if (!passwordEncoder.matches(password, findUser.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다.");
        }
        userRepository.deleteById(id);
    }
}
