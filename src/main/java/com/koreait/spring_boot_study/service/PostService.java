package com.koreait.spring_boot_study.service;

// B/S logic, 회원가입을 해서.. ID의 중복체크 등..

import com.koreait.spring_boot_study.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service

public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;

    }

    public String getPost(){
        String result = postRepository.getPost();
        return result;
    }


}
