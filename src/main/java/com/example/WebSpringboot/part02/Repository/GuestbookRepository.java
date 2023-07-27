package com.example.WebSpringboot.part02.Repository;

import com.example.WebSpringboot.part02.Entity.Guestbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface GuestbookRepository  extends JpaRepository<Guestbook,Long> ,
        QuerydslPredicateExecutor<Guestbook> {

}
