package com.dennis.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}


//  @RestController
//  컨트롤러를 JSON을 반환하는 컨트롤러를 만들어 준다.
//  예전에는 @ResponseBody를 각 메소드 마다 선언했던 것을
//  한번에 사용하게 해준다고 생각하면된다.

//  @GetMapping
//  HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어 준다.
//  예전에는 @RequestMapping(method = RequestMethod.GET)으로 사용