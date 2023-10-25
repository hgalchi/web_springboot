package com.example.WebSpringboot.part04.Repository;

import com.example.WebSpringboot.part04.Entity.Movie;
import com.example.WebSpringboot.part04.Entity.MoviewImage;
import com.example.WebSpringboot.part04.Entity.Review;
import com.example.WebSpringboot.part04.Entity.Reviewer;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void review등록() {

        IntStream.rangeClosed(1,5).forEach(i->{
            //리뷰어 번호
            Long mid = ((long) (Math.random() * 5) + 1);
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

    @Test
    public void Movie추출(){
        Movie m = Movie.builder().mno((long) 2).build();
        List<Review> listMovie = reviewRepository.findByMovie(m);

        listMovie.forEach(i->{
            System.out.println(i.getReviewnum());
            System.out.println(i.getGrade());
            System.out.println(i.getReviewer().getEmail());
            System.out.println(i.getText());
            System.out.println("=============================");
        });
    }

    @Test
    @Transactional
    @Commit
    public void 삭제transaction(){

        Long mid=(long)5;
        Reviewer reviewer = Reviewer.builder().mid(mid).build();

        reviewRepository.deleteById(mid);
        reviewRepository.deleteByReviewer(reviewer);
        //회원 삭제

    }

}