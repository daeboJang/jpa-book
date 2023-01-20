package me.devjang.smartd.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "boards", uniqueConstraints = {
        @UniqueConstraint(name = "UniqueGidAndBid", columnNames = {"group_id", "board_id"})
})
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;     // 대리키, auto_increment

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @Column(name = "board_id", nullable = false)
    private int boardId;

    private String name;

    private long timeStamp;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
