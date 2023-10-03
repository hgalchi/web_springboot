package com.example.WebSpringboot.part04.Repository;

import com.example.WebSpringboot.part04.Entity.Reviewer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewerRepositoryTest {

    @Autowired
    private ReviewerRepository reviewerRepository;

    @Test
    public void reviwer생성(){
        IntStream.rangeClosed(1, 20).forEach(i->{
            Reviewer r=Reviewer.builder()
                    .email("r"+i+"@naver.com")
                    .pw("1111")
                    .nickname("reviewer"+i)
                    .build();
            reviewerRepository.save(r);
        });
    }



}