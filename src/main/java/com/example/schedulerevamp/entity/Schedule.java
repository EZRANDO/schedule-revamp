package com.example.schedulerevamp.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String scheduleTitle;

    @Column(columnDefinition = "longtext")
    private String scheduleContent;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_schedule_user"))
    private User user;


    public Schedule() {

    }


    public void update(String name, String scheduleTitle, String scheduleContent) {
        this.name = name;
        this.scheduleTitle = scheduleTitle;
        this.scheduleContent = scheduleContent;
    }


}
