package com.example.WebSpringboot.part03.Repository;

import com.example.WebSpringboot.part03.Entity.Board;
import com.example.WebSpringboot.part03.Entity.Member;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @Test
    public void 보드추가() {



        IntStream.rangeClosed(1,20).forEach(i->{
            Member member = Member.builder().email("wyw"+i+"@naver.com").build();

            Board board = Board.builder()
                    .title(i + "번째 게시물")
                    .content(i + "내용")
                    .writer(member)
                    .build();

            boardRepository.save(board);
        });
    }

    @Test
    @Transactional
    public void read1(){
        Optional<Board> result = boardRepository.findById(10L);

        Board board = result.get();

        System.out.println(board);
        System.out.println(board.getWriter());
    }

    @Test
    @Transactional
    public void read2() {
        Object result = boardRepository.getBoardWithWirter(10L);
        Object[] arr=(Object[])result;

        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println(Arrays.toString(arr));
    }

}