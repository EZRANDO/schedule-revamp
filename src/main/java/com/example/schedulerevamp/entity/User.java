package com.example.schedulerevamp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user")
public class User extends ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    private String username;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    //유저 고유 식별자 저장. 연관관계를 설정.

    @Column(nullable = false)
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public User(String password) {
        this.password = password;
    }


    public void updateUser(String password) {
        this.password = password;
    }

}
