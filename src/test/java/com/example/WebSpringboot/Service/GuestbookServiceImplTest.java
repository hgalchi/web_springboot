package com.example.WebSpringboot.Service;

import com.example.WebSpringboot.part02.DTO.GuestbookDTO;
import com.example.WebSpringboot.part02.DTO.PageRequestDTO;
import com.example.WebSpringboot.part02.DTO.PageResultDTO;
import com.example.WebSpringboot.part02.Entity.Guestbook;
import com.example.WebSpringboot.part02.Service.GuestbookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GuestbookServiceImplTest {

    @Autowired
    private GuestbookService guestbookService;

    @Test
    public void 등록테스트() {

        GuestbookDTO dto = GuestbookDTO.builder().
                title("sample title")
                .content("sample content")
                .writer("sampel writer")
                .build();

        System.out.println(guestbookService.register(dto));
    }

    @Test
    public void 리스트테스트(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = guestbookService.getList(pageRequestDTO);

        for (GuestbookDTO dto : resultDTO.getDtoList()) {
            System.out.println(dto);
        }
    }

}