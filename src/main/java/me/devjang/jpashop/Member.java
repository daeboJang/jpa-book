package me.devjang.jpashop;

import javax.persistence.*;

@Entity
@Table(name = "shop_members")
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
