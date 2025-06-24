package com.koreait.spring_boot_study.repository;

public class PostRepository {
public String getPost(){
    System.out.println("레포지토리까지 요청이 왔다감.");
    return "Repository에서 온 데이터";
}



}
