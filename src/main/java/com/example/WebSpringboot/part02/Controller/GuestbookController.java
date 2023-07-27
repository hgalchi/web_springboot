package com.example.WebSpringboot.part02.Controller;

import com.example.WebSpringboot.part02.DTO.GuestbookDTO;
import com.example.WebSpringboot.part02.DTO.PageRequestDTO;
import com.example.WebSpringboot.part02.Service.GuestbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
@RequestMapping("/guestbook")
@RequiredArgsConstructor
public class GuestbookController {

    private final GuestbookService service;

    @GetMapping("/")
    @ResponseBody
    public String list() {
        log.info("list");
        return "hi";
    }

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDto) {
        log.info("list,,,,,,,,,,,,," + pageRequestDto);
        service.getList(pageRequestDto);
    }

    @PostMapping("/regisger")
    public String registerPost(GuestbookDTO dto) {
        log.info("register");

        Long gno = service.register(dto);

        return null;
    }

    @GetMapping("read")
    public void read(long gno) {
        log.info("gno content조회");

        GuestbookDTO dto = service.read(gno);


    }
}
