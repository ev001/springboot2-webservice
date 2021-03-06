package com.dennis.book.springboot.web;

import com.dennis.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}



//
//  @RestController
//  컨트롤러를 JSON을 반환하는 컨트롤러를 만들어 준다.
//  예전에는 @ResponseBody를 각 메소드 마다 선언했던 것을
//  한번에 사용하게 해준다고 생각하면된다.

//  @GetMapping
//  HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어 준다.
//  예전에는 @RequestMapping(method = RequestMethod.GET)으로 사용

//  RequestParam
//  외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
//  여기서는 외부에서 name (@RequestParam("name")) 이란
//  이름으로 넘긴 파라미터를 메소드 파라미터 name(String name)에 저장하게 된다.