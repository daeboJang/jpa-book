package me.devjang.jpashop;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shop_orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @Column(name = "order_no")
    private String orderNo;

    @Column(name = "order_date")
    private LocalDateTime orderedAt;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;          // 주문상태 -> enum type 으로 변경해야 함

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(LocalDateTime orderedAt) {
        this.orderedAt = orderedAt;
    }
}
