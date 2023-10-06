package com.example.WebSpringboot.part03.Repository.search;


import com.example.WebSpringboot.part03.Entity.Board;
import com.example.WebSpringboot.part03.Entity.QBoard;
import com.example.WebSpringboot.part03.Entity.QMember;
import com.example.WebSpringboot.part03.Entity.QReplay;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Repository
@RequiredArgsConstructor
public class SearchBoardRepositoryImpl implements SearchBoardRepository {

    private final JPAQueryFactory factory;


    @Override
    public Board search1() {
        log.info("search1...........");
        QBoard board = QBoard.board;

       Board result=factory.select(board).from(board).where(board.bno.eq(3L)).fetchOne();
        /*JPQLQuery<Board> jpqlQuery = from(board);
        List<Board> result = jpqlQuery.select(board).where(board.bno.eq(4L)).fetch();
        */


        log.info("=================================");
        log.info(factory);
        log.info("=================================");

        return result;
    }

    @Override
    public Object search2() {
        QBoard board = QBoard.board;
        QReplay replay = QReplay.replay;

        List<Board> result =factory.selectFrom(board).leftJoin(replay).on(replay.board.eq(board)).fetch();
        /*JPQLQuery<Board> jpqlQuery = from(board);
        jpqlQuery.leftJoin(replay).on(replay.board.eq(board));*/

        log.info("=================================");
        log.info(result);
        log.info("=================================");

        return null;
    }
    //left join ,on

    public Object search3() {

        QBoard board = QBoard.board;
        QReplay replay = QReplay.replay;
        QMember member = QMember.member;

        List<Tuple> result = factory.select(board, member.email, replay.count())
                .from(board).leftJoin(member).on(board.writer.eq(member))
                .leftJoin(replay).on(replay.board.eq(board)).fetch();

       /* JPQLQuery<Board> jpqlQuery = from(board);
        jpqlQuery.leftJoin(member).on(board.writer.eq(member));
        jpqlQuery.leftJoin(replay).on(replay.board.eq(board));

        jpqlQuery.select(board, member.email, replay.count());*/


        log.info("=================================");
        log.info(result);
        log.info("=================================");



        return null;

    }


    public Object search4() {
       QBoard board = QBoard.board;
        QReplay replay = QReplay.replay;
        QMember member = QMember.member;

         factory.select(board, member.email, replay.count()).from(board)
                .leftJoin(member).on(board.writer.eq(member))
                .leftJoin(replay).on(replay.board.eq(board))
                .groupBy(board).fetch();

       /* JPQLQuery<Board> jpqlQuery = from(board);
        jpqlQuery.leftJoin(member).on(board.writer.eq(member));
        jpqlQuery.leftJoin(replay).on(replay.board.eq(board));

        JPQLQuery<Tuple> tuple = jpqlQuery.select(board, member.email, replay.count());
        tuple.groupBy(board);
        List<Board> result = jpqlQuery.fetch();*/

        log.info("=================================");
        log.info(factory);
        log.info("=================================");



        return null;

    }

    @Override
    public Board search5() {
        return null;
    }


    @Override
    public Page<Object[]> searchPage(String type, String keyword, Pageable pageable) {

        log.info("searchPage.......................");

        QBoard board = QBoard.board;
        QReplay replay = QReplay.replay;
        QMember member = QMember.member;

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        BooleanExpression expression = board.bno.gt(0L);
        booleanBuilder.and(expression);

        if (type != null) {
            String[] typeArr = type.split("");

            BooleanBuilder conditionbuilder = new BooleanBuilder();

            for (String t : typeArr) {
                switch (t) {
                    case "t":
                        conditionbuilder.or(board.title.contains(keyword));
                        break;
                    case "w":
                        conditionbuilder.or(member.email.contains(keyword));
                        break;
                    case "c":
                        conditionbuilder.or(board.content.contains(keyword));
                        break;
                }
            }
            booleanBuilder.and(conditionbuilder);
        }

        JPAQuery<Tuple> query=factory.select(board, member, replay.count())
                .from(board)
                .leftJoin(member).on(board.writer.eq(member))
                .leftJoin(replay).on(replay.board.eq(board));

        query.where(booleanBuilder);

        //order by
        Sort sort = pageable.getSort();

        //요청받은  query결과를 정렬
        sort.stream().forEach(order->{
            Order direction=order.isAscending()?Order.ASC:Order.DESC;
            String prop = order.getProperty();
            PathBuilder orderByExpresion = new PathBuilder<>(Board.class, "board");

            query.orderBy(new OrderSpecifier(direction, orderByExpresion));
        });

        query.groupBy(board);

        //page처리
        query.offset(pageable.getOffset());
        query.limit(pageable.getPageSize());

        List<Tuple> result = query.fetch();
        long count = query.fetchCount();

        log.info("=================================");
        log.info("result : "+result);
        log.info("count : " + count);
        log.info("=================================");

        return new PageImpl<>(result.stream().map(t -> t.toArray()).collect(Collectors.toList()), pageable, count);


    }

}



