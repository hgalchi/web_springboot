package com.example.WebSpringboot.part05.repository;

import com.example.WebSpringboot.part05.Entity.ClubMember;
import com.example.WebSpringboot.part05.Entity.ClubMemberRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClubMemberRepoistoryTest {

    @Autowired
    private ClubMemberRepoistory repoistory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void 회원추가() {

        IntStream.rangeClosed(1,100).forEach(i->{
            ClubMember clubMember = ClubMember.builder()
                    .email("user" + i + "@naver.com")
                    .name("사용자" + i)
                    .fromSocial(false)
                    .password(passwordEncoder.encode("1111"))
                    .build();

            clubMember.addMemberRole(ClubMemberRole.USER);
            if (i > 90) {
                clubMember.addMemberRole(ClubMemberRole.ADMIN);
            }
            repoistory.save(clubMember);
        });
    }

    @Test
    public void 읽기(){
        Optional<ClubMember> result = repoistory.findByEmail("user1@naver.com", false);
        ClubMember clubMember = result.get();
        System.out.println(clubMember);
    }

}