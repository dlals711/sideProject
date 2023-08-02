package com.lym.project.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBasketItem is a Querydsl query type for BasketItem
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBasketItem extends EntityPathBase<BasketItem> {

    private static final long serialVersionUID = -348168748L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBasketItem basketItem = new QBasketItem("basketItem");

    public final QBasket basket;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QItem item;

    public QBasketItem(String variable) {
        this(BasketItem.class, forVariable(variable), INITS);
    }

    public QBasketItem(Path<? extends BasketItem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBasketItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBasketItem(PathMetadata metadata, PathInits inits) {
        this(BasketItem.class, metadata, inits);
    }

    public QBasketItem(Class<? extends BasketItem> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.basket = inits.isInitialized("basket") ? new QBasket(forProperty("basket"), inits.get("basket")) : null;
        this.item = inits.isInitialized("item") ? new QItem(forProperty("item")) : null;
    }

}

