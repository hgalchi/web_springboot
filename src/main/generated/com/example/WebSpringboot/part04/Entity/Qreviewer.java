package com.example.WebSpringboot.part04.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReviewer is a Querydsl query type for Reviewer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewer extends EntityPathBase<Reviewer> {

    private static final long serialVersionUID = 1597352389L;

    public static final QReviewer reviewer = new QReviewer("reviewer");

    public final com.example.WebSpringboot.part03.Entity.QBaseEntity _super = new com.example.WebSpringboot.part03.Entity.QBaseEntity(this);

    public final StringPath email = createString("email");

    public final NumberPath<Long> mid = createNumber("mid", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath nickname = createString("nickname");

    public final StringPath pw = createString("pw");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public QReviewer(String variable) {
        super(Reviewer.class, forVariable(variable));
    }

    public QReviewer(Path<? extends Reviewer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReviewer(PathMetadata metadata) {
        super(Reviewer.class, metadata);
    }

}

