package com.example.WebSpringboot.part04.Repository;

import com.example.WebSpringboot.part04.Entity.MoviewImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieImageRepository extends JpaRepository<MoviewImage, Long> {
}
