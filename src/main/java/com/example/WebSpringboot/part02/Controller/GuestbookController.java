package com.example.WebSpringboot.part02.Controller;

import com.example.WebSpringboot.part02.DTO.GuestbookDTO;
import com.example.WebSpringboot.part02.DTO.PageRequestDTO;
import com.example.WebSpringboot.part02.DTO.PageResultDTO;
import com.example.WebSpringboot.part02.Entity.Guestbook;
import com.example.WebSpringboot.part02.Service.GuestbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
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

    @PostMapping("/list")
    public void list(@RequestBody PageRequestDTO pageRequestDto) {
        log.info("list,,,,,,,,,,,,," + pageRequestDto);
        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDto);
        for (GuestbookDTO dto : resultDTO.getDtoList()) {
            System.out.println(dto);
        }
    }

    @PostMapping("/register")
    public String registerPost(@RequestBody GuestbookDTO dto) {
        log.info("register=====================================");

        Long gno = service.register(dto);

        return null;
    }

    @GetMapping("/read/{gno}")
    public void read(@PathVariable long gno) {

        log.info("gno content조회");
        GuestbookDTO dto = service.read(gno);
        System.out.println(" read"+gno+"dto=\n"+dto);


    }

    @PostMapping("/modify")
    public String modify(@RequestBody GuestbookDTO dto) {
        log.info("modify==================================");
        log.info("modify dto" + dto);

        return "modify gno="+service.modify(dto);

    }
}
