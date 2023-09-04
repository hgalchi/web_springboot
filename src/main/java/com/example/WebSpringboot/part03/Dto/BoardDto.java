package com.example.WebSpringboot.part03.Dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

    private Long bno;
    private String title;
    private String content;
    private String writerEmail;
    private String writerName;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private Long replyCount;


}
