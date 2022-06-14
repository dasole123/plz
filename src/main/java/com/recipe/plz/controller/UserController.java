package com.recipe.plz.controller;

import com.recipe.plz.dto.ResponseDto;
import com.recipe.plz.dto.SignupRequestDto;
import com.recipe.plz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입
    @PostMapping("/users/signup")
    public ResponseDto signup(@RequestBody SignupRequestDto signupRequestDto) {
        return userService.registerUser(signupRequestDto);
    }
}
//    // 이메일 중복 검사 - 모달
//    @PostMapping("/users/email")
//    public ResponseDto emailCheck(@RequestBody SignupRequestDto signupRequestDto){
//        return userService.emailCheck(signupRequestDto);
//    }

//    // 회원 로그인 페이지
//    @GetMapping("/users/login")
//    public String login() {
//        return "login";
//    }