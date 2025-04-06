package com.example.schedulerevamp.controller;

import com.example.schedulerevamp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class SessionController {

    private final UserService userService;



}