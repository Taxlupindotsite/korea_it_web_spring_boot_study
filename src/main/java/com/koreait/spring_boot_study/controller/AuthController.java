package com.koreait.spring_boot_study.controller;

import com.koreait.spring_boot_study.DTO.SigninReqDto;
import com.koreait.spring_boot_study.DTO.SignupReqDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String getUserName(@RequestParam(value="name", defaultValue = "홍길동") String username, @RequestParam(required = false) Integer age) {
        System.out.println(username + age);
        return username + age;
    }

//    http://localhost:8080/auth/get/name?username=구영현&age=27
//    value="name"추가시 username을 name으로 접근 가능
//    required=false 추가시 ..
//    나이 같은걸 int로 받으려 하면 안됨
//    Int와 Integer의 차이는 Int는 값이 없으면 아예 '없음'이고
//    Integer는 Null로 받음. 그래서 true/false를 걸려면 Integer로 받아야함

//    제일 좋은건 String으로 받는게 좋음 나중에는 ParseInt해서 Integer로 받고

//    안에서 사용하는 변수명과 쿼리스트링의 키값이 다를경우 괄호안에 표기해 주면 됨
//    그리고 기본값도 설정이 가능.
//    value뒤에 defaultValue = "홍길동"
//    다른 타입도 가능하며, 여러개의 RequestParam도 받을수 있음
//    단, int는 null을 허용 안하기 때문에 값이 '없음'의 상태가 될 수 있음
//    또, 만약 필수값이 false이고 기본값이 설정되어 있다면 필수값 설정이 무의미함.

//    이제 List를 받아볼것임

    @GetMapping("/get/names")
    public String getUserNames(@RequestParam List<String> names){
        return names.toString();

    }

//    RequestParam 주의사항
//    파라미터가 없으면 500에러라는게 뜸
//    타입이 안맞으면
//    이름이 불일치할때
//
//    Url에 정보가 다 보이기 때문에, 민감한 정보를 쓰면 안 됨

//    RequestParam은 보통 GetMapping일때(요청메소드가 get일때만 씀)
//    꼭 그래야만 하는건 아니지만 암튼 그럼

    /*
    실습
    1.요청주소는 /search => name, email(RequestParam)
    2.name은 필수x, email은 기본값으로 no-email
    3.요청은 /auth/search?name=lee
    4.반환은 "검색 조건 - 이름 : ***, 이메일 : ***"

     */

    @GetMapping("/search")
    public String searchUser
            (@RequestParam(required = false) String name,
            @RequestParam(defaultValue = "no-email") String email){
        return "검색 조건 - 이름 : " + name + ", 이메일 : " + email;

        //  http://localhost:8080/auth/search?name=구영현
    }

//    다음, @RequestBody
//    HTTP 요청,(get/put/delete 등)의 바디에 들어있는
//    JSON데이터를 자바 객체(DTO)로 변환해서 주입해주는 어노테이션
//    클라이언트가 JSON 형식으로 데이터 보냄.
//    백엔드 서버는 그 JSON을 @RequestBody가 붙은 DTO로 자동 매핑
//    일반적으로 Post, Put, Patch에서 사용됨.

//    DTO가 뭐냐
    /* Data Transfer Object

       데이터를 전달하기 위한 객체
       클라 간에 데이터를 주고받을 때 사용하는 중간 객체

     */

    @PostMapping("/signup")
    public String signup(@RequestBody SignupReqDto signupReqDto) {
        System.out.println("signUpRequestDto");
        return signupReqDto.getUsername() + "님 회원가입이 완료되었읍니다.";
    }

    /*
    실습
    Post요청 signin 로그인 로직
    SigninReqDto => email, password,
    반환 "로그인 완료 : " + signinReqDto.getEmail() + "님 반갑습니다."
    */

    @PostMapping("/signin")
    public String signin(@RequestBody SigninReqDto signinReqDto){
        return "로그인 완료 : " + signinReqDto.getEmail() + "님 반갑습니다." ;

    }



}
