package com.korit.basic.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.basic.dto.PostUserRequestDto;
import com.korit.basic.dto.ResponseDto;
import com.korit.basic.entity.UserEntity;
import com.korit.basic.repository.UserRepository;
import com.korit.basic.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

  private final UserRepository userRepository;

  @Override
  public ResponseEntity<ResponseDto> postUser(PostUserRequestDto dto) {
    
    String userId = dto.getUserId();
    String userTelNumber = dto.getUserTelNumber();

    try {

      // UserEntity userEntity = userRepository.findByUserId(userId);
      boolean isExistsUserId = userRepository.existsByUserId(userId);
      if (isExistsUserId) return ResponseDto.duplicatedId();
  
      // userEntity = userRepository.findByUserTelNumber(userTelNumber);
      boolean isExistsUserTelNumber = userRepository.existsByUserTelNumber(userTelNumber);
      if (isExistsUserTelNumber) return ResponseDto.duplicatedTelNumber();
  
      // UserEntity userEntity = new UserEntity(userId, dto.getUserPassword(), dto.getUserName(), dto.getUserAddress(), userTelNumber);
  
      // 빌더 패턴 : 객체 생성 과정에 멤버변수 별로 객체를 구성한 후 객체를 생성할 수 있도록 도움을 주는 생성 패턴
      // 특징 : 가독성 향상, 객체의 불변성을 보장
      // UserEntity userEntity = 
      //   UserEntity
      //     .builder()
      //     .userId(userId)
      //     .userPassword(dto.getUserPassword())
      //     .userName(dto.getUserName())
      //     .userAddress(dto.getUserAddress())
      //     .userTelNumber(userTelNumber)
      //     .build();
  
      UserEntity userEntity = new UserEntity(dto);
  
      userRepository.save(userEntity);

    } catch(Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    
    return ResponseDto.success(HttpStatus.CREATED);
  }
  
}
