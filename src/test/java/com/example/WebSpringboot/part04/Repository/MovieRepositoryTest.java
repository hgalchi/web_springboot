package com.example.WebSpringboot.part04.Repository;

import com.example.WebSpringboot.part04.Entity.Movie;
import com.example.WebSpringboot.part04.Entity.MoviewImage;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.UUID;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieRepositoryTest {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private MovieImageRepository movieImageRepository;

    @Commit
    @Transactional
    @Test
    public void movie테이블데이터추가() {
        IntStream.rangeClosed(1,20).forEach(i->{
            Movie movie = Movie.builder()
                    .title("Moview....")
                    .build();

            System.out.println("====================================");

            repository.save(movie);

            int count = (int) (Math.random() * 5) + 1;

            for (int j = 0; j < count; j++) {
                MoviewImage moviewImage = MoviewImage.builder()
                        .uuid(UUID.randomUUID().toString())
                        .movie(movie)
                        .imgName("test" + j + ".jpg")
                        .build();
                movieImageRepository.save(moviewImage);
            }

        });


    }



}