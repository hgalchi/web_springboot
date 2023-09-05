package com.example.WebSpringboot.part03.Controller;

import com.example.WebSpringboot.part02.DTO.PageRequestDTO;
import com.example.WebSpringboot.part03.Dto.BoardDto;
import com.example.WebSpringboot.part03.Service.BoardService;
import groovy.util.logging.Log4j;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    final private BoardService boardService;


    @GetMapping("/list")
    @ResponseBody
    public void list(PageRequestDTO pageRequestDTO) {

    }

    @PostMapping("/register")
    public void regitser(@RequestBody Map<String, String> map) {
        BoardDto boardDto = BoardDto.builder()
                .bno(Long.parseLong(map.get("bno")))
                .title(map.get("title"))
                .content(map.get("content"))
                .build();
        boardService.RegisterBoard(boardDto);
    }

    @GetMapping("/read/{bno}")
    public void read(@PathVariable Long bno) {
        BoardDto dto = boardService.get(bno);
        log.info(dto);
    }

    @PostMapping("/delete/{bno}")
    public void delete(@PathVariable Long bno) {
        boardService.removeWithReplies(bno);
        log.info("board delete succ");
    }
}
