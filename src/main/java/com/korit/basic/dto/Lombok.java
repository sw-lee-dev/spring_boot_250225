package com.korit.basic.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

// Lombok 라이브러리
// - getter, setter, constructor 등 자주 사용되지만 반복적으로 작성해야하는 코드를 자동으로 생성해주는 라이브러리
// - 프로젝트가 lombok 라이브러리 의존성을 가지고 있어야함
// - 대부분의 IDE는 기본적으로 Lombok 어노테이션에 대해 이해를 하지 못하기 때문에(에러로 받아들임) Lombok 추가 확장이 필요함

// @Getter : getter 메서드 생성
// @Setter : settre 메서드 생성
// @ToString : toString 메서드 생성 (필드명과 값을 문자열로 표현)
// @NoArgsConstructor : 기본 생성자 생성 (빈 생성자)
// @AllArgsConstructor : 모든 멤버변수를 매개변수로 받는 생성자 생성
// @RequiredArgsConstructor : 필수 멤버변수를 매개변수로 받는 생성자 생성
// @NoArgsConstructor >> 필수입력값이 생기면 빈 생성자는 사용못함
@AllArgsConstructor
@RequiredArgsConstructor
public class Lombok {
  private final String field1;
  private final int field2;
  private boolean field3;
  private Boolean field4;
}
