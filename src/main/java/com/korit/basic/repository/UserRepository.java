package com.korit.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.korit.basic.entity.UserEntity;

// User 테이블에 접근할 리포지토리
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
  // SELECT * FROM user WHERE user_id = ?; 와 같은 쿼리 메서드 -> findBy...
  UserEntity findByUserId(String userId);

  // SELECT * FROM user WHERE user_tel_number = ?;
  UserEntity findByUserTelNumber(String userTelNumber);

  boolean existsByUserId(String userId);
  boolean existsByUserTelNumber(String userTelNumber);

  // Query Method :
  // - JpaRepository의 메서드 선언 시에 지정된 규칙에 따라 메서드명을 작성하면 JPA가 SQL을 만들어주는 방법

  // - findBy [SELECT * WHERE] : 필드명을 기준으로 모든 컬럼을 조회할 때 사용함, findBy 바로 뒤에 필드명을 붙여서 작성, 필드명은 반드시 첫 글자가 대문자로 작성되어야함(!규칙 엄격!)
  // SELECT * FROM user WHERE user_name = ?; 를 Query Method로 표현
  // List 타입으로 반환받는 경우 결과가 없으면 길이가 0 인 리스트를 반환
  List<UserEntity> findByUserName(String userName);

  // - existsBy : 조건에 해당하는 레코드가 존재하는지 여부 확인 시 사용함
  // boolean 형태로 반환
  // SELECT * FROM user WHERE EXISTS (SELECT * FROM user WHERE user_name = ?); 서브퀴리 형태
  boolean existsByUserName(String userName);

  // - countBy : 조건에 해당하는 레코드의 개수 확인 시 사용함
  // int 형태로 반환
  // SELECT COUNT(*) FROM user WHERE user_name = ?;
  int countByUserName(String userName);

  // - And / Or : and 연산 혹은 or 연산에 사용됨, 필드와 필드 사이에 작성함
  // And Or 연산 시 우선순위 주의(And가 우선)
  // SELECT * FROM user WHERE user_name = ? AND user_address = ?;
  List<UserEntity> findByUserNameAndUserAddress(String userName, String userAddress);

  // - Like, NotLike, Containing, StatingWith, EndingWith : Like 연산에 사용함, 필드 뒤에 붙여서 사용함
  // SELECT * FROM user WHERE user_address LIKE '%?%';
  List<UserEntity> findByUserAddressLike(String userAddress);
  // SELECT * FROM user WHERE user_address LIKE '?%';
  List<UserEntity> findByUserAddressStatingWith(String userAddress);
}

// Spring Data JPA >> document >> LEARN >> Reference DOC 확인