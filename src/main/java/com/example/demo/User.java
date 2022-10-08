package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String team;

    protected User() {
    }

    protected User(String name, String team) {
        this.name = name;
        this.team = team;
    }

    // getters and setters are hidden for brevity

    @Override
    public String toString() {
        return id + ". " + name + " likes the " + team;
    }
}