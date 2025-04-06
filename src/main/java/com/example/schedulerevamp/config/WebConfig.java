package com.example.schedulerevamp.config;

import com.example.schedulerevamp.filter.CustomFilter;
import com.example.schedulerevamp.filter.LoginFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean customFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean= new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new CustomFilter());        // 필터 등록
        filterRegistrationBean.setOrder(1);                          // 필터 실행 순서 (낮을수록 먼저)
        filterRegistrationBean.addUrlPatterns("/*");
        // 필터 적용 URL
        return filterRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean loginFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LoginFilter());
        filterRegistrationBean.setOrder(2);
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;

    }
    }

