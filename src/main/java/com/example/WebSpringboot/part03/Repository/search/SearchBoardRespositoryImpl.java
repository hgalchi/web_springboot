package com.example.WebSpringboot.part03.Repository.search;

import com.example.WebSpringboot.part03.Entity.Board;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

@Log4j2
public class SearchBoardRespositoryImpl extends QuerydslRepositorySupport implements SearchBoardRepository {
    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
    public SearchBoardRespositoryImpl(Class<?> domainClass) {
        super(domainClass);
    }

    @Override
    public Board search1() {
        log.info("search1...........");
        return null;
    }
}
