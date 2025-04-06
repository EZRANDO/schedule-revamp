package com.example.schedulerevamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ScheduleRevampApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleRevampApplication.class, args);
    }

}
