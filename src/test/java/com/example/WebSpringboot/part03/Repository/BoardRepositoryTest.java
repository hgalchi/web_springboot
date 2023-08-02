package com.example.WebSpringboot.part03.Repository;

import com.example.WebSpringboot.part03.Entity.Board;
import com.example.WebSpringboot.part03.Entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @Test
    public void 보드추가() {

        IntStream.rangeClosed(1,20).forEach(i->{



            Board board= Board.builder()
                    .title(i+"번째 게시물")
                    .content(i+"내용")
                    .build();

            boardRepository.save(board);
        });
    }

}