package com.example.WebSpringboot.part03.Repository;

import com.example.WebSpringboot.part03.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,String> {

    Object findByNameAndEmail(String username, String email);

    List<Member> findByRegDateBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<Member> findByNameStartingWith(String nic);

}
