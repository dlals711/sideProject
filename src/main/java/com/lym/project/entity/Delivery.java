package com.lym.project.entity;

import com.lym.project.entity.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;
    @Embedded
    Address address;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;
}
