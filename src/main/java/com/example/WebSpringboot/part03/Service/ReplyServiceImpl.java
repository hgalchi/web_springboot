package com.example.WebSpringboot.part03.Service;


import com.example.WebSpringboot.part03.Dto.ReplyDTO;
import com.example.WebSpringboot.part03.Entity.Board;
import com.example.WebSpringboot.part03.Entity.Replay;
import com.example.WebSpringboot.part03.Repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository repository;

    //글 등록
    @Override
    public Long register(ReplyDTO dto) {
        Replay en= DtoToEntity(dto);
        repository.save(en);
        //entity로 변환

        return dto.getRno();
    }

    //bno가 같은 게시글 반환
    @Override
    public List<ReplyDTO> getList(long bno) {
        //해당 rno를 얻는데 rno를 내림차순으로 정렬해서 결과를 반환하기 -> 복잡하다 @query를 사용해서 생성하기
        List<Replay> list = repository.getRepliesByBoardOrderByRno(Board.builder().bno(bno).build());
        return list.stream().map(en -> EntityToDto(en)).collect(Collectors.toList());
    }

    //수정이 완료된 dto를 save
    @Override
    public void modify(ReplyDTO dto) {
        repository.save(DtoToEntity(dto));
    }

    @Override
    public void remove(Long rno) {
        //repository.deleteByRno(rno);
        repository.deleteById(rno);
    }
}
