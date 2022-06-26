package com.example.tournament.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Integer playerId;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team teamId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "height")
    private Integer height;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "position_on_court")
    private Integer positionOnCourt;
    @Column(name = "num_of_games")
    private Integer numOfGames;

    public Player(Integer playerId, Team teamId, String firstName, String lastname, Date dateOfBirth, Integer height, Integer weight, Integer positionOnCourt, Integer numOfGames) {
        this.playerId = playerId;
        this.teamId = teamId;
        this.firstName = firstName;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.weight = weight;
        this.positionOnCourt = positionOnCourt;
        this.numOfGames = numOfGames;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public Integer getNumOfGames() {
        return numOfGames;
    }
    public void setNumOfGames(Integer numOfGames) {
        this.numOfGames = numOfGames;
    }
    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", teamId=" + teamId +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", height=" + height +
                ", weight=" + weight +
                ", positionOnCourt=" + positionOnCourt +
                ", numOfGames=" + numOfGames +
                '}';
    }
}
