package com.korit.basic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korit.basic.dto.GetUserListResponseDto;
import com.korit.basic.dto.GetUserResponseDto;
import com.korit.basic.dto.PatchUserRequestDto;
import com.korit.basic.dto.PostUserRequestDto;
import com.korit.basic.dto.ResponseDto;
import com.korit.basic.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
  
  private final UserService userService;

  @PostMapping("")
  public ResponseEntity<ResponseDto> postUser(
    @RequestBody @Valid PostUserRequestDto requestBody
  ) {
    ResponseEntity<ResponseDto> response = userService.postUser(requestBody);
    return response;
  }

  @GetMapping("")
  public ResponseEntity<? super GetUserListResponseDto> getUserList() {
    ResponseEntity<? super GetUserListResponseDto> response = userService.getUserList();
    return response;
  }

  @GetMapping("/{userId}")
  public ResponseEntity<? super GetUserResponseDto> getUser(
    @PathVariable("userId") String userId
  ) {
    ResponseEntity<? super GetUserResponseDto> response = userService.getUser(userId);
    return response;
  }

  @PatchMapping("/{userId}")
  public ResponseEntity<ResponseDto> patchUser(
    @PathVariable("userId") String userId,
    @RequestBody @Valid PatchUserRequestDto requestBody
  ) {
    ResponseEntity<ResponseDto> response = userService.patchUser(userId, requestBody);
    return response;
  }

  @DeleteMapping("/{userId}")
  public ResponseEntity<ResponseDto> deleteUser(
    @PathVariable("userId") String userId
  ) {
    ResponseEntity<ResponseDto> response = userService.deleteUser(userId);
    return response;
  }

}
