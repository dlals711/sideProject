package com.lym.project.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember2 is a Querydsl query type for Member2
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember2 extends EntityPathBase<Member2> {

    private static final long serialVersionUID = 1109739229L;

    public static final QMember2 member2 = new QMember2("member2");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final ListPath<String, StringPath> roles = this.<String, StringPath>createList("roles", String.class, StringPath.class, PathInits.DIRECT2);

    public QMember2(String variable) {
        super(Member2.class, forVariable(variable));
    }

    public QMember2(Path<? extends Member2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember2(PathMetadata metadata) {
        super(Member2.class, metadata);
    }

}

