package com.dennis.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)


@WebMvcTest
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));    // mvc.perform의 결과를 검증
        // 응답 본문의 내용을 검증
        // Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는 검증한다.
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;
        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }


}

// RunWith : 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다.
// 여기서는 SpringRunner라는 스프링 실행자를 사용
// 스프링 부트 테스트와 JUnit 사이에 연결자 역할.

// WebMvcTest : Web(Spring MVC)에 집중할 수 있는 어노테이션
// 선언할 경우 @Controller, @ControllerAdvice 등 사용가능
// But, @Service, @Component, @Repository 등은 사용 불가
// 여기서는 컨트롤러만 사용하기 때문에 선언.

// Autowired :스프링이 관리하는 빈(Bean)을 주입받는다.

// private MockMvc mvc : 웹 API를 테스트 할 때 사용.
// 스프링 MVC 테스트의 시작점.
// 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있음

// param
// API 테스트 할 때 사용될 요청 파라미터를 설정
// 값은 String 만 허용
// 그래서 숫자/날짜 드의 데이터도 등록할 때는 문자열로 변경해야만 가능.

// jsonPath
// JSON 응답값을 필드별로 검증할 수 있는 메소드
// $를 기준으로 필드명을 명시
// 여기서는 name과 amount를 검증하니 $.name, $.amount로 검증.