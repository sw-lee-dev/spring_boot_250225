package com.korit.basic.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.basic.dto.PostUserRequestDto;
import com.korit.basic.dto.ResponseDto;
import com.korit.basic.service.UserService;

@Service
public class UserServiceImplement implements UserService {

  @Override
  public ResponseEntity<ResponseDto> postUser(PostUserRequestDto dto) {
    throw new UnsupportedOperationException("Unimplemented method 'postUser'");
  }
  
}
