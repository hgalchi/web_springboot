package com.example.WebSpringboot.part03.Service;

import com.example.WebSpringboot.part03.Dto.BoardDto;
import com.example.WebSpringboot.part03.Repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceImplTest {

    @Autowired
    private BoardServiceImpl service;

    @Test
    public void 게시물등록() {
        BoardDto dto=BoardDto.builder()
                .title("TEST....")
                .content("TEST>>>>")
                .writerEmail("wyw3@naver.com")
                .build();

        Long bno = service.RegisterBoard(dto);
    }

}