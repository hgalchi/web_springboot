package com.example.WebSpringboot.part03.Repository;

import com.example.WebSpringboot.part03.Entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void 멤버추가(){

        IntStream.rangeClosed(1,20).forEach(i->
        {
            Member member= Member.builder()
                    .email("wyw"+i+"@naver.com")
                    .pw(i+"password")
                    .name("user"+i)
                    .build();

            memberRepository.save(member);
        });
    }

}