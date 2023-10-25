package com.example.WebSpringboot.part05.service;


import com.example.WebSpringboot.part05.Entity.ClubMember;
import com.example.WebSpringboot.part05.Entity.Note;
import com.example.WebSpringboot.part05.dto.NoteDto;

import java.util.List;

public interface NoteService {

    Long register(NoteDto noteDto);

    NoteDto get(Long num);

    void modify(NoteDto noteDto);

    void remove(Long num);

    List<NoteDto> getAllWithWriter(String writerEmail);

    default Note dtoToEntity(NoteDto dto) {
        Note note = Note.builder()
                .num(dto.getNum())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(ClubMember.builder().email(dto.getWriterEmail()).build())
                .build();
        return note;
    }

    default NoteDto EntityToDto(Note note) {
        NoteDto dto=NoteDto.builder()
                .content(note.getContent())
                .title(note.getTitle())
                .num(note.getNum())
                .modDate(note.getModDate())
                .regDate(note.getRegDate())
                .writerEmail(note.getWriter().getEmail())
                .build();

        return dto;
    }
}
