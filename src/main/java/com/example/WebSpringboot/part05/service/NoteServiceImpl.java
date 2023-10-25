package com.example.WebSpringboot.part05.service;

import com.example.WebSpringboot.part05.Entity.Note;
import com.example.WebSpringboot.part05.dto.NoteDto;
import com.example.WebSpringboot.part05.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository repository;


    @Override
    public Long register(NoteDto noteDto) {
        Note note = dtoToEntity(noteDto);
        repository.save(note);
        return note.getNum();
    }

    @Override
    public NoteDto get(Long num) {
        Optional<Note> result = repository.getWithWriter(num);
        if (result.isPresent()) {
            return EntityToDto(result.get());
        }
        return null;
    }

    @Override
    public void modify(NoteDto noteDto) {
        Long num = noteDto.getNum();

        Optional<Note> result = repository.findById(num);

        if (result.isPresent()) {
            Note note=result.get();
            note.changeContent(noteDto.getContent());
            note.changeTitle(noteDto.getTitle());
            repository.save(note);
        }
    }

    @Override
    public void remove(Long num) {

        repository.deleteById(num);
    }

    @Override
    public List<NoteDto> getAllWithWriter(String writerEmail) {
        List<Note> noteList = repository.getList(writerEmail);
        return noteList.stream().map(note->EntityToDto(note)).collect(Collectors.toList());
    }
}
