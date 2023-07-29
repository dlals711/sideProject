package com.lym.project.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Basket extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id")
    private Long id;
    @Column(length = 5)
    private int count;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
