package com.example.WebSpringboot.part05.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class NoteDto {

    private Long num;

    private String title;

    private String content;

    private String writerEmail;

    private LocalDateTime regDate,modDate;
}
