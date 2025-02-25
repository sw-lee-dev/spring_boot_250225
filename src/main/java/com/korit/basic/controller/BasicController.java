package com.korit.basic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Controller 레이어:
// - 클라이언트와 서버간의 접점
// - 클라이언트의 요청을 받고 해당 요청에 대한 응답을 처리
// - 각 요청의 HTTP method와 url에 해당하는 메서드를 작성하는 공간

// @RestController : JSON 형태의 ResponseBody를 반환하는 Controller 임을 명시
// @Controller + @ ResponseBody
// @Controller : 해당 클래스가 HTML 형태의 ResponseBody를 반환하는 Controller 임을 명시
// @ResponseBody : 컨트롤러의 응답형태를 직접 조작할 수 있도록 함
@RestController

// @RequestMapping : HTTP 요청에 클래스 혹은 메서드를 URL 및 HTTP Method 등으로 매핑하기 위한 어노테이션
// HTTP GET 127.0.0.1:8080/basic/**
// @RequestMapping(value="/basic", method=RequestMethod.GET)
@RequestMapping("/basic")
public class BasicController {
  
  // GET http://localhost:8080/basic/first
  @RequestMapping(value = "/first", method = RequestMethod.GET)
  public String firstMethod() {
    return "Spring Boot 첫번째 메소드";
  }

}
