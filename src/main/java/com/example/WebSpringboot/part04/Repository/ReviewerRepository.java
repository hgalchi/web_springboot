package com.example.WebSpringboot.part04.Repository;

import com.example.WebSpringboot.part04.Entity.Reviewer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Pageable;

public interface ReviewerRepository extends JpaRepository<Reviewer, Long> {



}
