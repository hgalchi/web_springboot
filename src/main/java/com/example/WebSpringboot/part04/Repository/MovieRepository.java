package com.example.WebSpringboot.part04.Repository;

import com.example.WebSpringboot.part04.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
