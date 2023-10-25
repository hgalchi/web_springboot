package com.example.WebSpringboot.part04.Repository.Querydsl;

import com.example.WebSpringboot.part04.Entity.QMovie;
import com.example.WebSpringboot.part04.Entity.QMoviewImage;
import com.example.WebSpringboot.part04.Entity.QReview;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MovieQueryImpl implements MovieQuery {

    private final JPAQueryFactory factory;

    /*public Page<Object[]> getListMovie(){

        QMovie movie = QMovie.movie;
        QMoviewImage moviewImage = QMoviewImage.moviewImage;
        QReview review = QReview.review;

        JPAQuery<Tuple> result = factory.select(movie, moviewImage,review.grade.avg(),review.count()).from(movie)
                .leftJoin(moviewImage).on(movie.eq(moviewImage.movie))
                .leftJoin(review).on(review.movie.eq(movie))
                .groupBy(movie);


    }*/
}
