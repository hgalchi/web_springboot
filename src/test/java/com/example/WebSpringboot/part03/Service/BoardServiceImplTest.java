package com.example.WebSpringboot.part03.Service;

import com.example.WebSpringboot.part02.DTO.PageRequestDTO;
import com.example.WebSpringboot.part02.DTO.PageResultDTO;
import com.example.WebSpringboot.part03.Dto.BoardDto;
import com.example.WebSpringboot.part03.Entity.Board;
import com.example.WebSpringboot.part03.Repository.BoardRepository;
import jakarta.transaction.Transactional;
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

    @Test
    public void 리스트반환() {

        PageRequestDTO pageRequestDTO = new PageRequestDTO();

        PageResultDTO<BoardDto, Object[]> result = service.getList(pageRequestDTO);

        for (BoardDto boardDto : result.getDtoList()) {
            System.out.println(boardDto);

        }
    }

    @Test
    public void 게시물조회() {
        BoardDto result = service.get(3L);
        System.out.println(result);
    }

    @Test
    public void  게시물삭제() {
        service.removeWithReplies(4L);
    }

    @Test
    public void 게시물수정() {
        BoardDto dto = BoardDto.builder()
                .content("내용을 변경합니다. ")
                .title("제목을 변경합니다.")
                .bno(2L)
                .build();

        service.modify(dto);
    }

}