package com.greenfox.javatribes.javatribes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "kingdoms")
public class Kingdom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "kingdom_id")
    @JsonProperty("kingdomId")
    private long Id;

    private String name;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Kingdom() {
    }

    public Kingdom(String name) {
        this.name = name;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
