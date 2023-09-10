package com.example.WebSpringboot.part03.Repository;

import com.example.WebSpringboot.part03.Entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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

    @Test
    public void find() {
        Object member = memberRepository.findByNameAndEmail("user1", "wyw1@naver.com");
        System.out.println("member" + member);
    }

    @Test
    public void between() {
        LocalDateTime start = LocalDateTime.of(2023, 8, 4, 0, 15);
        LocalDateTime end=LocalDateTime.of(2023, 8, 4, 0, 16);
        List<Member> list = memberRepository.findByRegDateBetween(start, end);
        for (Member member : list) {
            System.out.println(member);
        }
    }

    @Test
    public void like() {
        String nic = "user";
        List<Member> list= memberRepository.findByNameStartingWith(nic);
        for (Member member : list) {
            System.out.println(member);
        }
    }

}