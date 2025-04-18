package com.korit.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.korit.basic.dto.Lombok;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicApplication.class, args);
	}

	void method()	{
		Lombok lombok1 = new Lombok("a",1,false,true);
		Lombok lombok2 = new Lombok("a",1);

		lombok1.getField1();
		lombok1.isField3(); // 기본형 boolean은 is로 받음
		lombok1.getField4(); // 참조형 Boolean은 get으로 받음

		lombok2.setField3(false);
		lombok2.setField4(null);
	}

}
