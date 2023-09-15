package com.example.WebSpringboot.part03.Service;

import com.example.WebSpringboot.part03.Dto.ReplyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyServiceImplTest {

    @Autowired
    private ReplyServiceImpl service;

    @Test
    public void testGetList() {
        Long bno=12L;
        List<ReplyDTO> list = service.getList(bno);
        list.forEach((dto) -> System.out.println(dto));
    }

}