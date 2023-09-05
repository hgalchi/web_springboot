package com.example.WebSpringboot.part03.Repository;

import com.example.WebSpringboot.part03.Entity.Replay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Replay, Long> {

    @Modifying
    @Query("delete from Replay r where r.board.bno=:bno")
    void deleteByBno(@Param("bno") Long bno);
}
