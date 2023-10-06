package com.example.WebSpringboot.part04.Repository;

import com.example.WebSpringboot.part04.Entity.Movie;
import com.example.WebSpringboot.part04.Entity.Review;
import com.example.WebSpringboot.part04.Entity.Reviewer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @EntityGraph(attributePaths = {"reviewer"}, type = EntityGraph.EntityGraphType.FETCH)
    List<Review> findByMovie(Movie movie);

    //void deleteByReviewer(Reviewer reviewer);

    @Modifying
    @Query("delete from Review mr where mr.reviewer=:reviewer")
    void deleteByReviewer(@Param("reviewer") Reviewer reviewer);
}
