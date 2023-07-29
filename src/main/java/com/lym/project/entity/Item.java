package com.lym.project.entity;

import com.lym.project.entity.enums.ItemStatus;
import com.lym.project.entity.enums.MemberRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;
    @Column(length = 100)
    private String name;
    @Column(length = 10)
    private int quantity;
    @Column(length = 10)
    private int price;
    @Column(length = 500)
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private ItemStatus status;
}
