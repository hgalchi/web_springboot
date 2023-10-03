package com.example.WebSpringboot.part04.Repository;

import com.example.WebSpringboot.part04.Entity.Movie;
import com.example.WebSpringboot.part04.Entity.Review;
import com.example.WebSpringboot.part04.Entity.Reviewer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;
    //1~5점까지의 평점과 리뷰 내용을 등록
    @Test
    public void review등록() {



        IntStream.rangeClosed(1,5).forEach(i->{
            //리뷰어 번호
            Long mid = ((long) (Math.random() * 20) + 1);
            Reviewer reviewer = Reviewer.builder().mid(mid).build();

            Review r = Review.builder()
                    .grade(i % 2)
                    .text(" 영화에 대해"+i)
                    .reviewer(reviewer)
                    .movie(Movie.builder().mno((long)i).build())
                    .build();
            reviewRepository.save(r);
        });




    }

}