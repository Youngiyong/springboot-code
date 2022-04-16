package com.giyong.querydsl.controller;


import com.giyong.querydsl.model.dto.UserDto;
import com.giyong.querydsl.model.request.UserRequest;
import com.giyong.querydsl.model.response.ServerSuccessResponse;
import com.giyong.querydsl.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@ApiResponses({
        @ApiResponse(
                code = 200, message = "OK", response = ResponseEntity.class, responseContainer = "Object"),
        @ApiResponse(
                code = 400, message = "Bad Request", response = Object.class  , responseContainer = "Object")
})
@RequestMapping("/api/v1/auth/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @ApiOperation(value = "로그인")
    @PostMapping("/signup")
    public ServerSuccessResponse signup(
            @Valid @RequestBody UserRequest.UserSign request, BindingResult result) {
        if (result.hasErrors()) {
            throw new RuntimeException();
        }
        userService.signup(request);
        return new ServerSuccessResponse();
    }

    @ApiOperation(value = "업데이트")
    @PutMapping("/{id}")
    public ServerSuccessResponse update(
            @PathVariable Long id,
            @Valid @RequestBody UserRequest.UserUpdate request, BindingResult result) {

        if (result.hasErrors()) {
            throw new RuntimeException();
        }

        userService.update(id, request);
        return new ServerSuccessResponse();

    }

    @ApiOperation(value = "유저 정보 조회")
    @GetMapping("/{id}")
    public UserDto.User getUserInfo(
            @PathVariable Long id){

        return userService.getUserInfo(id);
    }
}
