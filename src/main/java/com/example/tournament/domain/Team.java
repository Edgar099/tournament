package com.example.tournament.domain;

import javax.persistence.*;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_team;
    private String team_name;
    private String city;

    public Team(Integer id_team, String team_name, String city) {
        this.id_team = id_team;
        this.team_name = team_name;
        this.city = city;
    }

    public Team() {

    }

    public Integer getId_team() {
        return id_team;
    }

    public void setId_team(Integer id_team) {
        this.id_team = id_team;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
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
                "id_team=" + id_team +
                ", team_name='" + team_name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
