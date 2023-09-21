package com.example.WebSpringboot.part04.Repository;

import com.example.WebSpringboot.part04.Entity.MoviewImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieImageRepository extends JpaRepository<MoviewImage, Long> {
}
