package com.example.WebSpringboot.repository;

import com.example.WebSpringboot.part02.Entity.Guestbook;
import com.example.WebSpringboot.Entity.QGuestbook;
import com.example.WebSpringboot.part02.Repository.GuestbookRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class GuestbookRepositoryTests {
    @Autowired
    private GuestbookRepository guestbookRepository;

    @Test
    public void insertdummies(){
        IntStream.rangeClosed(1,300).forEach(i->{
            Guestbook guestbook= Guestbook.builder()
                    .title("Title"+i)
                    .content("content"+i)
                    .writer("writer"+i)
                    .build();
            System.out.println(guestbookRepository.save(guestbook));
        });
    }

    @Test
    public void 수정시간테스트(){
        Optional<Guestbook> book = guestbookRepository.findById(300L);
        if (book.isPresent()) {
            Guestbook guestbook=book.get();

            guestbook.changeContent("Change content");
            guestbook.changeTitle("change Title");

            guestbookRepository.save(guestbook);
        }
    }

    @Test
    public void 복합querydsl테스트(){

        Pageable pageable = PageRequest.of(0, 10, Sort.by("gno").descending());

        QGuestbook qguestbook = QGuestbook.guestbook;

        String keyword = "1";

        BooleanBuilder builder = new BooleanBuilder();

        BooleanExpression exTitle = qguestbook.title.contains(keyword);

        BooleanExpression exContent = qguestbook.content.contains(keyword);

        BooleanExpression exAll = exTitle.or(exContent);

        builder.and(exAll);

        builder.and(qguestbook.gno.gt(0L));

        Page<Guestbook> list = guestbookRepository.findAll(builder, pageable);

        list.stream().forEach(i->{
            System.out.println(i);
        });
    }

    @Test
    public void querydsl테스트(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("gno").descending());

        QGuestbook qGuestbook=QGuestbook.guestbook;

        String keyword = "1";

        BooleanBuilder builder = new BooleanBuilder();

        BooleanExpression expression = qGuestbook.title.contains(keyword);

        builder.and(expression);

        Page<Guestbook> result = guestbookRepository.findAll(builder, pageable);

        result.stream().forEach(guestbook -> {
            System.out.println(guestbook);
        });


    }
}
