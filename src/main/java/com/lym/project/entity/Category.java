package com.lym.project.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    @Column(length = 50)
    private String name;



}
