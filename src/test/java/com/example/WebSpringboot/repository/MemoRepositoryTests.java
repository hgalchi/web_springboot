package com.example.WebSpringboot.repository;


import com.example.WebSpringboot.part01.Entity.Memo;
import com.example.WebSpringboot.part01.Repository.MemoRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void 테스트(){
        System.out.println(memoRepository.getClass().getName());
    }

    @Test
    public void 등록작업테스트(){
        IntStream.rangeClosed(1,100).forEach(i->{
            Memo memo=Memo.builder().build();
            memoRepository.save(memo);
        });
    }

    @Test
    public void 조회작업_테스트(){
        Long mno=100L;

        Optional<Memo> result = memoRepository.findById(mno);
        System.out.println("=====================");
        if (result.isPresent()) {
            Memo memo=result.get();
            System.out.println(memo);
        }
    }

    @Test
    public void 수정작업_테스트(){
        Memo memo = Memo.builder().mno(100L).build();
        System.out.println(memoRepository.save(memo));
    }

    @Test
    public void 삭제작업_테스트(){

        Long mno=100L;
        memoRepository.deleteById(mno);
    }

    @Test
    public void 페이징_테스트(){

        Pageable pageable = PageRequest.of(0, 10);

        Page<Memo> result = memoRepository.findAll(pageable);

        System.out.println(result);

        System.out.println("======================");

        System.out.println("Total Pages : " + result.getTotalPages());

        System.out.println("Total Count : " + result.getTotalElements());

       for(Memo memo : result.getContent()){
           System.out.println(memo);
       }

    }

    @Test
    public void 정렬조건페이징_테스트() {
        Sort sort = Sort.by("mno").descending();

        Pageable pageable = PageRequest.of(0, 10, sort);

        Page<Memo> result = memoRepository.findAll(pageable);

        result.get().forEach(memo->{
            System.out.println(memo);
        });
    }

    @Test
    public void 쿼리메서드_테스트(){

        List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(70L, 80L);
        for(Memo memo: list)
            System.out.println(memo);
    }

    @Test
    public void 쿼리메서드페이징(){

        Sort sort = Sort.by("mno").descending();

        Pageable pageable = PageRequest.of(0, 10, sort);

        Page<Memo> list = memoRepository.findByMnoBetween(70L, 80L, pageable);

        list.get().forEach(t -> System.out.println(t));
    }
    @Commit
    @Transactional
    @Test
    public void 삭제기능_테스트(){
        memoRepository.deleteMemoByMnoLessThan(10L);
    }
}
