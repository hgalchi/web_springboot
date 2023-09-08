package com.example.WebSpringboot.part03.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReplay is a Querydsl query type for Replay
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReplay extends EntityPathBase<Replay> {

    private static final long serialVersionUID = -942937754L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReplay replay = new QReplay("replay");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QBoard board;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath replayer = createString("replayer");

    public final NumberPath<Long> rno = createNumber("rno", Long.class);

    public final StringPath text = createString("text");

    public QReplay(String variable) {
        this(Replay.class, forVariable(variable), INITS);
    }

    public QReplay(Path<? extends Replay> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReplay(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReplay(PathMetadata metadata, PathInits inits) {
        this(Replay.class, metadata, inits);
    }

    public QReplay(Class<? extends Replay> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new QBoard(forProperty("board"), inits.get("board")) : null;
    }

}

