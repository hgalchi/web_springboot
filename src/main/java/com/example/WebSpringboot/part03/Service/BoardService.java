package com.example.WebSpringboot.part03.Service;

import com.example.WebSpringboot.part02.DTO.PageRequestDTO;
import com.example.WebSpringboot.part02.DTO.PageResultDTO;
import com.example.WebSpringboot.part03.Dto.BoardDto;
import com.example.WebSpringboot.part03.Entity.Board;
import com.example.WebSpringboot.part03.Entity.Member;
import com.example.WebSpringboot.part03.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface BoardService {


    //게시물 등록
    Long RegisterBoard(BoardDto dto);

    //목록처리
    PageResultDTO<BoardDto, Object[]> getList(PageRequestDTO pageRequestDTO);

    //게시물 조회처리
    BoardDto get(Long bno);

    //게시물 삭제
    void removeWithReplies(Long bno);

    //게시물 수정
    void modify(BoardDto boardDto);

    //엔티티타입으로 변환
    default Board DtoToEntity(BoardDto dto) {

        Member member = Member.builder().email(dto.getWriterEmail()).build();
        Board board=Board.builder()
                .title(dto.getTitle())
                .bno(dto.getBno())
                .content(dto.getContent())
                //writer은 member객체를 담고 있다 첫번째로 dto의 gno필드의 값으로 jpa로 객체를 찾아서 넣으려고 했다.
                //근데 member객체에 email값만 채운채로 객체를 만들어서 파라미터로 넘기고 있네
                .writer(member)
                .build();
        return board;
    }

    default BoardDto EntityToDto(Board board, Member member, Long replyCount) {

        BoardDto dto=BoardDto.builder()
                .writerEmail(member.getEmail())
                .regDate(member.getRegDate())
                .writerName(member.getName())
                .modDate(member.getModDate())
                .bno(board.getBno())
                .replyCount(replyCount)
                .content(board.getContent())
                .title(board.getTitle())
                .build();
        return dto;
    }



}
