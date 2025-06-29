package com.koreait.spring_boot_study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")

public class AuthController {

//    @RequestParam
//    클라가 Url 쿼리스트링으로 넘긴 값을 메소드 파라미터로 전달

    @GetMapping("/get")
    public String getUser(@RequestParam String userId) {
        System.out.println("RequestParam으로 들어온 값 : " + userId);
        return "RequestParam으로 들어온 값 : " + userId;
    }

//    http://localhost:8080/auth/get?userId=10으로 체크

    @GetMapping("/get/name")
    public String getUserName(@RequestParam(value="name") String username, @RequestParam(required = false) Integer age) {
        System.out.println(username + age);
        return username + age;
    }
//    http://localhost:8080/auth/get/name?username=구영현&age=27
//    value="name"추가시 username을 name으로 접근 가능
//    required=false 추가시 ..
//    나이 같은걸 int로 받으려 하면 안됨
//    Int와 Integer의 차이는 Int는 값이 없으면 아예 없는거고
//    Integer는 Null로 받음. 그래서 true/false를 걸려면 Integer로 받아야함

//    47:03

}
