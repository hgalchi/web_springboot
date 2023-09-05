package com.example.WebSpringboot.part03.Service;

import com.example.WebSpringboot.part02.DTO.PageRequestDTO;
import com.example.WebSpringboot.part02.DTO.PageResultDTO;
import com.example.WebSpringboot.part03.Dto.BoardDto;
import com.example.WebSpringboot.part03.Entity.Board;
import com.example.WebSpringboot.part03.Entity.Member;
import com.example.WebSpringboot.part03.Entity.Replay;
import com.example.WebSpringboot.part03.Repository.BoardRepository;
import com.example.WebSpringboot.part03.Repository.ReplyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Log4j2
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;
    private final ReplyRepository replyRepository;


    //게시물을 등록하고 bno값 반환하기
    @Override
    public Long RegisterBoard(BoardDto dto) {
        log.info(dto);
        repository.save(DtoToEntity(dto));
        return dto.getBno();
    }

    @Override
    public PageResultDTO<BoardDto, Object[]> getList(PageRequestDTO pageRequestDTO) {
        log.info(pageRequestDTO);
        //Object[]를 boardDto로 변경하기 위한 함수 인터페이스
        Function<Object[], BoardDto> fn = en -> EntityToDto((Board) en[0], (Member) en[1], (Long) en[2]);

        Page<Object[]> result = repository.getBoardWithReplayCount(
                pageRequestDTO.getPageable(Sort.by("bno").descending())
        );

        return new PageResultDTO<>(result, fn);
    }

    @Transactional
    @Override
    public void removeWithReplies(Long bno) {
        //댓글부터 삭제
        replyRepository.deleteByBno(bno);
        repository.deleteById(bno);


    }

    @Override
    public void modify(BoardDto boardDto) {
        Board board = repository.getById(boardDto.getBno());

        if (board != null) {
            Board b = (Board) board;
            b.changeTitle(boardDto.getContent());
            b.changeTitle(boardDto.getTitle());

            repository.save(board);
        }
    }

    @Override
    public BoardDto get(Long bno) {

        Object result = repository.getBoardByBno(bno);
        Object[] arr = (Object[]) result;
        return EntityToDto((Board) arr[0], (Member) arr[1], (Long) arr[2]);

    }


}
