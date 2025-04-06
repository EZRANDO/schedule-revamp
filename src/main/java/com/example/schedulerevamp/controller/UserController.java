package com.example.schedulerevamp.controller;

import com.example.schedulerevamp.dto.user.*;
import com.example.schedulerevamp.entity.User;
import com.example.schedulerevamp.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * {@code UserController} 클래스는 일정 관련 HTTP 요청을 처리하는 REST 컨트롤러입니다.
 * <p>
 * 일정 생성, 조회, 수정, 삭제(CRUD) 기능을 제공하며,
 * {@link UserService}를 통해 비즈니스 로직을 위임받아 처리합니다.
 * <p>
 * 이 컨트롤러는 클라이언트로부터 받은 사용자 관련 요청을 처리하고,
 * 적절한 응답을 반환하는 역할을 합니다.
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 신규 사용자 등록.
     *
     * @param requestDto 회원 가입 요청 정보
     * @return 등록된 사용자 정보와 201(CREATED) 응답
     */

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@Valid @RequestBody SignUpRequestDto requestDto) {
        SignUpResponseDto signUpResponseDto =
                userService.signUp(
                        requestDto.getUsername(),
                        requestDto.getEmail(),
                        requestDto.getPassword()
                );

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    /**
     * 사용자 로그인.
     *
     * @param requestDto 로그인 요청 정보
     * @param request HttpServletRequest
     * @return 로그인 성공 시 200 OK와 메시지, 실패 시 401 UNAUTHORIZED
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(
            @SessionAttribute(name = "sessionKey", required = false)
            @Valid @RequestBody LoginRequestDto requestDto,
            HttpServletRequest request
    ) {

        User user = userService.login(requestDto.getEmail(), requestDto.getPassword());

        if(user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        HttpSession session = request.getSession();

        session.setAttribute("sessionKey", user);

        return ResponseEntity.ok("로그인 되었습니다.");
    }

    /**
     * 사용자 정보 조회.
     *
     * @param id 사용자 ID
     * @return 200(OK) 응답
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        UserResponseDto userResponseDto = userService.findById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    /**
     * 사용자 정보 수정.
     *
     * @param id 사용자 ID
     * @param requestDto 사용자 이름 또는 이메일 변경 요청 정보
     * @return 200(OK) 응답
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUsernameRequestDto requestDto) {
        userService.updateUser(
                id,
                requestDto.getPassword(),
                requestDto.getNewPassword());


        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 해당하는 ID 사용자 삭제.
     *
     * @param id 사용자 ID
     * @return 200(OK) 응답
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id, @RequestBody PasswordCheckRequestDto requestDto) {
        userService.delete(id, requestDto.getPassword());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}


