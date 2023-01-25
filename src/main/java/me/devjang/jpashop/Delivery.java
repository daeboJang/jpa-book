package me.devjang.jpashop;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shop_deliveries")
public class Delivery {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "delivery_date")
    private LocalDateTime when;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery")        // 읽기전용 - 참조만
    private Order order;

    // 배송주소 (address)
    private String city;
    private String street;
    private String zipcode;
}
