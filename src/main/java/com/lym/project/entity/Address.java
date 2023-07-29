package com.lym.project.entity;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Column(length = 50)
    private String city;
    @Column(length = 50)
    private String district;
    @Column(length = 50)
    private String street;
    @Column(length = 100)
    private String detail;
    @Column(length = 1)
    private int rating;

}
