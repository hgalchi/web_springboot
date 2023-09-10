package com.example.WebSpringboot.part03.Repository.search;

import com.example.WebSpringboot.part03.Entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchBoardRepository {
    //board타입 객체를 반환
    Board search1();

    Object search2();

    Object search3();


    Object search4();

    //Dto를 repository영역에서 사용하지 않기 위해
   // Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
}
