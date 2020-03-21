package com.dennis.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Application class 는 이 프로젝트의 메인 클래스.

@SpringBootApplication
// └ 역할 : 스프링 부트의 자동설정, 스프링 Bean읽기와 생성 모두 자동으로 설정.
//          @SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에
//          이 클래스는 항상 프로젝트의 최상단에 위치해야하만 한다.
public class Application {
    public static void main(String[] args){
        // SpringApplication.run으로 인해 내장 was가 자동 실행됨.
        SpringApplication.run(Application.class, args);
    }
}
