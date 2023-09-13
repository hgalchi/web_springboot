package com.example.WebSpringboot.part03.Repository;

import com.example.WebSpringboot.part02.DTO.PageRequestDTO;
import com.example.WebSpringboot.part02.DTO.PageResultDTO;
import com.example.WebSpringboot.part03.Dto.BoardDto;
import com.example.WebSpringboot.part03.Entity.Board;
import com.example.WebSpringboot.part03.Entity.Member;
import com.mysql.cj.log.Log;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;


@SpringBootTest
class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @Test
    public void 보드추가() {


        IntStream.rangeClosed(1, 20).forEach(i -> {
            Member member = Member.builder().email("wyw" + i + "@naver.com").build();

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
    public void read1() {
        Optional<Board> result = boardRepository.findById(10L);

        Board board = result.get();

        System.out.println(board);
        System.out.println(board.getWriter());
    }

    @Test
    @Transactional
    public void read2() {
        //todo : object[] 어떤 방식으로 cast되는지 알아보기
        Object result = boardRepository.getBoardWithWriter(10L);
        Object[] arr = (Object[]) result;

        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println(Arrays.toString(arr));
    }


    @Test
    @Transactional
    public void 게시글과댓글() {
        List<Object[]> result = boardRepository.getBoardWithReplay(4L);
        for (Object[] arr : result) {
            System.out.println(Arrays.toString(arr));

        }
    }

    @Test
    @Transactional
    public void 목록pageable() {
        Pageable pageable= PageRequest.of(0,10, Sort.by("bno").descending());
        Page<Object[]> result = boardRepository.getBoardWithReplayCount(pageable);
        result.get().forEach(row->{
            Object[] arr = (Object[])  row;
            System.out.println(Arrays.toString(arr));

        });
    }

    @Test
    @Transactional
    public void 특정한게시번호() {
        Object result = boardRepository.getBoardByBno(14L);
        Object[] arr = (Object[]) result;
        System.out.println(Arrays.toString(arr));

    }
    @Test
    @Transactional
    public void 쿼리연결테스트() {
        Object board = boardRepository.search2();
        System.out.println(board);

    }

    @Test
    public void SearchPageTest() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        //Page<Object[]> result = boardRepository.searchPage("t", "1", pageable);
    }


}