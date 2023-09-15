package com.example.WebSpringboot.part03.Service;

import com.example.WebSpringboot.part03.Dto.ReplyDTO;
import com.example.WebSpringboot.part03.Entity.Board;
import com.example.WebSpringboot.part03.Entity.Replay;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReplyService {

    public Long register(ReplyDTO dto);

    public List<ReplyDTO> getList(long bno);

    public void modify(ReplyDTO dto);

    public void remove(Long rno);


    default ReplyDTO EntityToDto(Replay en) {
        ReplyDTO dto = ReplyDTO.builder()
                .rno(en.getRno())
                .text(en.getText())
                .replyer(en.getReplayer())
                // todo : bno초기화를 왜 안하지? 모든 필드 값을 넘겨줘야하는거아님?-> build패턴 글 정리하기
                //.bno(en.get)
                .regDate(en.getRegDate())
                .modDate(en.getModDate())
                .build();

        return dto;
    }
        //board와는 다른 방식? 이것도 먹어봐이건가
    default Replay DtoToEntity(ReplyDTO dto ) {

        Board board=Board.builder()
                .bno(dto.getBno())
                .build();

        Replay en = Replay.builder()
                .rno(dto.getRno())
                .text(dto.getText())
                .replayer(dto.getReplyer())
                .board(board)
                .build();

        return en;

    }

}

