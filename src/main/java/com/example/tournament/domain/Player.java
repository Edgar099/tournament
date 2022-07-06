package com.example.tournament.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Integer playerId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team teamId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "age")
    private Integer age;
    @Column(name = "height")
    private Integer height;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "position_on_court")
    private Integer positionOnCourt;


    public Player(Team teamId, String firstName, String lastname,  Integer height, Integer weight, Integer age, Integer positionOnCourt) {
        this.teamId = teamId;
        this.firstName = firstName;
        this.lastname = lastname;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.positionOnCourt = positionOnCourt;
    }

    public Player(Integer playerId, Team teamId, String firstName, String lastname,  Integer height, Integer weight,Integer age, Integer positionOnCourt) {
        this.playerId = playerId;
        this.teamId = teamId;
        this.firstName = firstName;
        this.lastname = lastname;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.positionOnCourt = positionOnCourt;
    }

    public Player() {

    }

    public Integer getPlayerId() {
        return playerId;
    }
    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Team getTeamId() {
        return teamId;
    }
    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }
    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getPositionOnCourt() {
        return positionOnCourt;
    }
    public void setPositionOnCourt(Integer positionOnCourt) {
        this.positionOnCourt = positionOnCourt;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", teamId=" + teamId +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", positionOnCourt=" + positionOnCourt +
                '}';
    }
}
