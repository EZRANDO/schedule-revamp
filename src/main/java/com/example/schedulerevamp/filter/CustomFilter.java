package com.example.schedulerevamp.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;

/**
 * 요청 URI를 가로채기 위한 커스텀 필터입니다.
 * <p>
 * 현재는 요청 URI를 추출하고 다음 필터로 넘기기만 하며,
 * 공통 처리 로직 추가 시 확장 가능합니다.
 */
@Slf4j
public class CustomFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();


        chain.doFilter(request, response);
    }
}
