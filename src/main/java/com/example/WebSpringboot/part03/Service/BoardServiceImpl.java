package com.example.WebSpringboot.part03.Service;

import com.example.WebSpringboot.part02.DTO.PageRequestDTO;
import com.example.WebSpringboot.part02.DTO.PageResultDTO;
import com.example.WebSpringboot.part03.Dto.BoardDto;
import com.example.WebSpringboot.part03.Entity.Board;
import com.example.WebSpringboot.part03.Entity.Member;
import com.example.WebSpringboot.part03.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository repository;


    //게시물을 등록하고 bno값 반환하기
    @Override
    public Long RegisterBoard(BoardDto dto) {
        log.info(dto);
        repository.save(DtoToEntity(dto));
        return dto.getBno();
    }
//todo : 266p
    /*@Override
    public PageResultDTO<BoardDto, Object[]> getList(PageRequestDTO pageRequestDTO) {
        log.info(pageRequestDTO);
        Function<Object[], BoardDto> fn = en -> EntityToDto((Board) en[0], (Member) en[1], (Long) en[2]);

        Page<Object[]> result = repository.getBoardWithReplayCount(
                pageRequestDTO.getPageable(Sort.by("bno").descending())
        );
    }*/
}
