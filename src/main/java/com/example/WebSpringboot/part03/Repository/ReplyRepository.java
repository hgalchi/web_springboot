package com.example.WebSpringboot.part03.Repository;

import com.example.WebSpringboot.part03.Entity.Board;
import com.example.WebSpringboot.part03.Entity.Replay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Replay, Long> {

    @Modifying
    @Query("delete from Replay r where r.board.bno=:bno")
    void deleteByBno(@Param("bno") Long bno);

    List<Replay> getReplayByBoardOrderByRno(Board board);

    void deleteByRno(Long rno);

    //todo : 테이블이름은 reply인데 왜 replies라고 명시되어 있지?
    List<Replay> getRepliesByBoardOrderByRno(Board board);
}
