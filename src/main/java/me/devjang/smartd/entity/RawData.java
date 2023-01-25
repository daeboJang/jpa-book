package me.devjang.smartd.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "data_raw", uniqueConstraints = {
        @UniqueConstraint(name = "UniqRawData", columnNames = {"group_id", "board_id", "ts"})
})
public class RawData {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "board_id")
    private Integer boardId;

    private Long ts;    // 저장된 timestamp

//    private int m1;
//    private int m2;
//    private int m3;
//    private int m4;

    @Embedded
    private SensorValue value;
}
