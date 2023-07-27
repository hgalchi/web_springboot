package com.example.WebSpringboot.part02.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;


@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {

    private int page;
    private int size;

    //default생성자가 클래스내에 선언
    public PageRequestDTO(){
        //페이지 번호는 기본값을 가지는것이 좋기때문
        this.page=1;
        this.size=10;
    }

    public PageRequest getPageable(Sort sort) {
        return PageRequest.of(page, size, sort);
    }
}
