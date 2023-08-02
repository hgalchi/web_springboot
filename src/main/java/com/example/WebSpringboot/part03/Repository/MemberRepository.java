package com.example.WebSpringboot.part03.Repository;

import com.example.WebSpringboot.part03.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,String> {
}
