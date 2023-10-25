package com.example.WebSpringboot.part04.Repository;

import com.example.WebSpringboot.part04.Entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    //하 매우매우 중요 쿼리메서드 사용시 한줄을 띄었을 때 꼭!! 공백을 추가해주자

    @Query("select m, mi, avg(coalesce(r.grade,0)),count(distinct r) from Movie m "
            +"left outer join MoviewImage mi on mi.movie=m "
            +"left outer join Review r on r.movie = m group by m")
    Page<Object[]> getListPage(Pageable pageable);



    @Query("select m , mi,avg(coalesce(r.grade,0)), count(r) from Movie m " +
            "left outer join MoviewImage mi on mi.movie=m "+
            "left outer join Review r on r.movie=m "+
            "where m.mno= :mno group by mi")
    List<Object[]> getMovieWithAll(@Param("mno") Long mno);
}
