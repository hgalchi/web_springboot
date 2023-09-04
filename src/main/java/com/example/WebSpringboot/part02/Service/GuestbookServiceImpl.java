package com.example.WebSpringboot.part02.Service;

import com.example.WebSpringboot.part02.DTO.GuestbookDTO;
import com.example.WebSpringboot.part02.DTO.PageRequestDTO;
import com.example.WebSpringboot.part02.DTO.PageResultDTO;
import com.example.WebSpringboot.part02.Entity.Guestbook;
import com.example.WebSpringboot.part02.Repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService {

    final GuestbookRepository repository;
    @Override
    public Long register(GuestbookDTO dto) {
        log.info("DTO");
        log.info(dto);

        Guestbook entity = dtoToEntity(dto);

        log.info(entity);

        repository.save(entity);

        return entity.getGno();


    }

    @Override
    public GuestbookDTO read(Long gno) {
        Optional<Guestbook> result = repository.findById(gno);

        return result.isPresent() ? entityToDto(result.get()) : null;
    }

    @Override
    public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());


        Page<Guestbook> result = repository.findAll(pageable);

        Function<Guestbook, GuestbookDTO> fn = (entity -> entityToDto(entity));

        return new PageResultDTO<>(result, fn);

    }

    @Override
    public Long modify(GuestbookDTO dto) {
// gno를 같이 처리하도록 했는데 왜 안되지? 그리고 null일텐데?
        if (repository.findById(dto.getGno()) == null) {
            System.out.println(repository.findById(dto.getGno()));
            return null;
        }

        System.out.println(repository.findById(dto.getGno()));

        //dto를 entity로 변경
        Guestbook entity = dtoToEntity(dto);

        //repository save
        repository.save(entity);

        return entity.getGno();
    }


}