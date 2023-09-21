package com.example.WebSpringboot.part04.Repository;

import com.example.WebSpringboot.part04.Entity.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewerRepository extends JpaRepository<Reviewer, Long> {


}
