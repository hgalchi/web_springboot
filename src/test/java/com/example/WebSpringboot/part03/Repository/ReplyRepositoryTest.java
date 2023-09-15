package com.example.WebSpringboot.part03.Repository;

import com.example.WebSpringboot.part03.Entity.Board;
import com.example.WebSpringboot.part03.Entity.Replay;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyRepositoryTest {

    @Autowired
    ReplyRepository repository;

    @Test
    public void 댓글추가() {
        IntStream.rangeClosed(1, 20).forEach(i -> {
            long bno = (long)(Math.random()*20)+1;

            /*todo : 참조하는 테이블을 찾아서 넣어준것도 아닌데?,
          save하지도 않았는데 왜 튜플이 자동으로 생성된거지?

             */
            Board board = Board.builder().bno(bno).build();

            Replay reply = Replay.builder()
                    .text("Reply........" + i)
                    .board(board)
                    .replayer("guest")
                    .build();

            repository.save(reply);
        });
    }

    @Test
    @Transactional
    //todo : lazy 영속성 컨텍스트 관련해서 글 작성하기
    public void 보드리스트() {
        List<Replay> replyList = repository.getReplayByBoardOrderByRno(Board.builder()
                .bno(14L).build());
        replyList.forEach(replay -> System.out.println(replay));
    }

}