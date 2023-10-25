package com.example.WebSpringboot.part05.controller;

import com.example.WebSpringboot.part05.dto.NoteDto;
import com.example.WebSpringboot.part05.service.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
//@RequestMapping("/notes")
@RequiredArgsConstructor

public class NoteController {

    private final NoteService noteService;

    @PreAuthorize("permitAll()")
    @PostMapping("/")
    public ResponseEntity<Integer> register(@RequestBody NoteDto dto) {

        log.info("---------------------register-------------------------");

        Long num = noteService.register(dto);

        return new ResponseEntity<>(1, HttpStatus.OK);

    }

    @PreAuthorize("permitAll()")
    @GetMapping("/test")
    @ResponseBody
    public String test() {

        return "test";
    }

}
