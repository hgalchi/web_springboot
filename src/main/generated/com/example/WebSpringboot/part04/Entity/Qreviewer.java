package com.example.WebSpringboot.part04.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * Qreviewer is a Querydsl query type for reviewer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qreviewer extends EntityPathBase<reviewer> {

    private static final long serialVersionUID = 1532708261L;

    public static final Qreviewer reviewer = new Qreviewer("reviewer");

    public final com.example.WebSpringboot.part03.Entity.QBaseEntity _super = new com.example.WebSpringboot.part03.Entity.QBaseEntity(this);

    public final NumberPath<Long> mid = createNumber("mid", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath nickname = createString("nickname");

    public final StringPath pw = createString("pw");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public Qreviewer(String variable) {
        super(reviewer.class, forVariable(variable));
    }

    public Qreviewer(Path<? extends reviewer> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qreviewer(PathMetadata metadata) {
        super(reviewer.class, metadata);
    }

}

