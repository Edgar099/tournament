package com.example.tournament.domain;
import javax.persistence.*;
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

    public Team(Integer teamId, String teamName, String city) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.city = city;
    }
    @OneToOne(mappedBy = "team")
    private Coach coach;

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

    @Override
    public String toString() {
        return "Team{" +
                "id_team=" + teamId +
                ", team_name='" + teamName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
