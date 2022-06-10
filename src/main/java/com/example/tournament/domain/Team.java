package com.example.tournament.domain;

import javax.persistence.*;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @Column
    private Integer idTeam;
    @Column
    private String teamName;
    @Column
    private String city;

    public Team(Integer idTeam, String teamName, String city) {
        this.idTeam = idTeam;
        this.teamName = teamName;
        this.city = city;
    }

    public Team() {

    }

    public Integer getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Integer idTeam) {
        this.idTeam = idTeam;
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

    @Override
    public String toString() {
        return "Team{" +
                "id_team=" + idTeam +
                ", team_name='" + teamName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
