package com.example.WebSpringboot.part03.Repository;

import com.example.WebSpringboot.part03.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("select b,w from Board b left join b.writer w where b.bno= :bno")
    Object getBoardWithWriter(@Param("bno") Long bno);

   /* @Query("select *from board")
    Object getboard();*/
}
