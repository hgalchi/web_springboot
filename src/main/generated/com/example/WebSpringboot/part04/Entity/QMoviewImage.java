package com.example.WebSpringboot.part04.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMoviewImage is a Querydsl query type for MoviewImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMoviewImage extends EntityPathBase<MoviewImage> {

    private static final long serialVersionUID = 1186124436L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMoviewImage moviewImage = new QMoviewImage("moviewImage");

    public final StringPath imgName = createString("imgName");

    public final NumberPath<Long> inum = createNumber("inum", Long.class);

    public final QMovie movie;

    public final StringPath path = createString("path");

    public final StringPath uuid = createString("uuid");

    public QMoviewImage(String variable) {
        this(MoviewImage.class, forVariable(variable), INITS);
    }

    public QMoviewImage(Path<? extends MoviewImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMoviewImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMoviewImage(PathMetadata metadata, PathInits inits) {
        this(MoviewImage.class, metadata, inits);
    }

    public QMoviewImage(Class<? extends MoviewImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.movie = inits.isInitialized("movie") ? new QMovie(forProperty("movie")) : null;
    }

}

