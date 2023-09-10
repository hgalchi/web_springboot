package com.example.WebSpringboot.part03.Repository.search;


import com.example.WebSpringboot.part03.Entity.Board;
import com.example.WebSpringboot.part03.Entity.QBoard;
import com.example.WebSpringboot.part03.Entity.QMember;
import com.example.WebSpringboot.part03.Entity.QReplay;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Log4j2
public class SearchBoardRepositoryImpl extends QuerydslRepositorySupport implements SearchBoardRepository {

    public SearchBoardRepositoryImpl() {
        super(Board.class);

    }

    @Override
    public Board search1() {
        log.info("search1...........");
        QBoard board = QBoard.board;

        JPQLQuery<Board> jpqlQuery = from(board);

        jpqlQuery.select(board).where(board.bno.eq(4L));

        log.info("=================================");
        log.info(jpqlQuery);
        log.info("=================================");

        List<Board> result = jpqlQuery.fetch();

        return null;
    }

    @Override
    public Object search2() {
        QBoard board = QBoard.board;
        QReplay replay = QReplay.replay;

        JPQLQuery<Board> jpqlQuery = from(board);
        jpqlQuery.leftJoin(replay).on(replay.board.eq(board));

        return null;
    }
    //left join ,on

    public Object search3() {

        QBoard board=QBoard.board;
        QReplay replay = QReplay.replay;
        QMember member = QMember.member;

        JPQLQuery<Board> jpqlQuery = from(board);
        jpqlQuery.leftJoin(member).on(board.writer.eq(member));
        jpqlQuery.leftJoin(replay).on(replay.board.eq(board));

        jpqlQuery.select(board, member.email, replay.count());


        log.info("=================================");
        log.info(jpqlQuery);
        log.info("=================================");

        List<Board> result = jpqlQuery.fetch();

        return null;

    }


    public Object search4() {
        QBoard board=QBoard.board;
        QReplay replay = QReplay.replay;
        QMember member = QMember.member;

        JPQLQuery<Board> jpqlQuery = from(board);
        jpqlQuery.leftJoin(member).on(board.writer.eq(member));
        jpqlQuery.leftJoin(replay).on(replay.board.eq(board));

        JPQLQuery<Tuple> tuple = jpqlQuery.select(board, member.email, replay.count());
        tuple.groupBy(board);

        log.info("=================================");
        log.info(tuple);
        log.info("=================================");

        List<Board> result = jpqlQuery.fetch();

        return null;

    }

  /*  @Override*/
    /*public Page<Object[]> searchPage(String type, String keyword, Pageable pageable) {

        log.info("searchPage.......................");

        QBoard board = QBoard.board;
        QReplay replay = QReplay.replay;
        QMember member = QMember.member;

        JPQLQuery<Board> jpqlQuery = from(board);
        jpqlQuery.leftJoin(member).on(board.writer.eq(member));
        jpqlQuery.leftJoin(replay).on(replay.board.eq(board));

        JPQLQuery<Tuple> tuple = jpqlQuery.select(board, member, replay.count());

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        BooleanExpression booleanExpression = board.bno.gt(0L);

        booleanBuilder.and(booleanExpression);

        if (type != null) {
            String[] typeArr = type.split("");
            BooleanBuilder conditionBuilder = new BooleanBuilder();
//todo : 307p
            for (String t : typeArr) {

                }
            }
        }*/

    }



