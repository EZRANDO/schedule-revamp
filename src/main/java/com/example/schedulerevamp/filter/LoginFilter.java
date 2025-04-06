package com.example.schedulerevamp.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

/**
 * 세션 기반 인증을 처리하는 로그인 필터입니다.
 * <p>
 * 화이트리스트 경로를 제외한 모든 요청에 대해 세션을 검사하며,
 * 세션 또는 사용자 정보가 없는 경우 예외를 발생시킵니다.
 */
@Slf4j
public class LoginFilter implements Filter {

    /**
     * 로그인 없이 접근 가능한 경로 목록
     */
    private static final String[] WHITE_LIST =  {"/", "/users/signup", "/users/login"};

    /**
     * 인증 필터 로직.
     * 세션 유무와 사용자 인증 여부 검사.
     *
     * @param req    요청 객체
     * @param res    응답 객체
     * @param chain  필터 체인
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String uri = request.getRequestURI();

        // 인증이 필요한 경로인지 확인
        if (!isWhisList(request)) {
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("sessionKey") == null) {
                throw new RuntimeException("로그인 해주세요");
            }
        }

        chain.doFilter(req, res);
    }

    /**
     * 요청 URI가 화이트리스트에 포함되어 있는지.
     *
     * @param request 요청 객체
     * @return 화이트리스트 여부
     */
    private boolean isWhisList(HttpServletRequest request) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, request.getRequestURI());
    }
}
