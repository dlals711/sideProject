package com.lym.project.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasketItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;
}
