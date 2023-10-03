package com.example.WebSpringboot.part04.Repository;

import com.example.WebSpringboot.part04.Entity.Movie;
import com.example.WebSpringboot.part04.Entity.MoviewImage;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

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

            movieRepository.save(movie);

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

    @Test
    public void 목록화면(){
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by( "mno"));

        Page<Object[]> result = movieRepository.getListPage(pageRequest);

        result.getContent().forEach(i->{
            System.out.println(Arrays.toString(i));
        });

    }

    //todo:377
    @Test
    public void 영화이미지() {
        List<Object[]> result = movieRepository.getMovieWithAll((long) 1);
        result.forEach(i -> System.out.println(Arrays.toString(i)));

    }




}