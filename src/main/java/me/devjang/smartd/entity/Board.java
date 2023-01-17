package me.devjang.smartd.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "UniqueGidAndBid", columnNames = {"group_id", "board_id"})
})
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(name = "board_id")
    private int boardId;

    private String name;

    private long timeStamp;
}
