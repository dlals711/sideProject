package com.lym.project.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @Column(length = 100)
    private String title;
    @Column(length = 1024)
    private String content;
    @Column(length = 1)
    private int rating;


}
