package com.example.tournament.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "team")
public class Team {
    @Id
    @Column(name = "team_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teamId;
    @Column(name = "team_name")
    private String teamName;
    @Column(name = "city")
    private String city;
    @OneToOne
    @JoinColumn(name = "coach_id")
    private Coach coachId;

    public Team(Integer teamId, String teamName, String city, Coach coachId) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.city = city;
        this.coachId = coachId;
    }

    public Team(String teamName, String city, Coach coachId) {
        this.teamName = teamName;
        this.city = city;
        this.coachId = coachId;
    }
    public Team() {

    }

    public Integer getIdTeam() {
        return teamId;
    }
    public void setIdTeam(Integer idTeam) {
        this.teamId = idTeam;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Coach getCoachId() {
        return coachId;
    }
    public void setCoachId(Coach coachId) {
        this.coachId = coachId;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", city='" + city + '\'' +
                ", coachId=" + coachId +
                '}';
    }
}
