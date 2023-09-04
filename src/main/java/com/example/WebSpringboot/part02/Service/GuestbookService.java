package com.example.WebSpringboot.part02.Service;

import com.example.WebSpringboot.part02.DTO.GuestbookDTO;
import com.example.WebSpringboot.part02.DTO.PageRequestDTO;
import com.example.WebSpringboot.part02.DTO.PageResultDTO;
import com.example.WebSpringboot.part02.Entity.Guestbook;

public interface GuestbookService  {
    Long register(GuestbookDTO dto);

    GuestbookDTO read(Long gno);

    PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO);

    Long modify(GuestbookDTO dto);

    default Guestbook dtoToEntity(GuestbookDTO dto) {
        Guestbook entity = Guestbook.builder()
                // .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
        return entity;
    }

    default GuestbookDTO entityToDto(Guestbook entity) {
        GuestbookDTO dto = GuestbookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }


}
