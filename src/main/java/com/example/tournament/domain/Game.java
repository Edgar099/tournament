package com.example.tournament.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "game")
public class Game {
    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameId;
    @Column(name = "tour_num")
    private Integer tourNum;
    @OneToOne
    @JoinColumn(name = "home_team_id")
    private Team homeTeamId;
    @OneToOne
    @JoinColumn(name = "visit_team_id")
    private Team visitorTeamId;
    @Column(name = "points_home_team")
    private Integer pointsH;
    @Column(name = "points_visit_team")
    private Integer pointsV;

    public Game(Integer tourNum, Team homeTeamId, Team visitorTeamId, Integer pointsH, Integer pointsV) {
        this.tourNum = tourNum;
        this.homeTeamId = homeTeamId;
        this.visitorTeamId = visitorTeamId;
        this.pointsH = pointsH;
        this.pointsV = pointsV;
    }
    public Game(Integer gameId, Integer tourNum, Team homeTeamId, Team visitorTeamId, Integer pointsH, Integer pointsV) {
        this.gameId = gameId;
        this.tourNum = tourNum;
        this.homeTeamId = homeTeamId;
        this.visitorTeamId = visitorTeamId;
        this.pointsH = pointsH;
        this.pointsV = pointsV;
    }
    public Game() {
    }
    public Integer getGameId() {
        return gameId;
    }
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
    public Integer getTourNum() {
        return tourNum;
    }
    public void setTourNum(Integer tourNum) {
        this.tourNum = tourNum;
    }
    public Team getHomeTeamId() {
        return homeTeamId;
    }
    public void setHomeTeamId(Team homeTeamId) {
        this.homeTeamId = homeTeamId;
    }
    public Team getVisitorTeamId() {
        return visitorTeamId;
    }
    public void setVisitorTeamId(Team visitorTeamId) {
        this.visitorTeamId = visitorTeamId;
    }
    public Integer getPointsH() {
        return pointsH;
    }
    public void setPointsH(Integer pointsH) {
        this.pointsH = pointsH;
    }
    public Integer getPointsV() {
        return pointsV;
    }
    public void setPointsV(Integer pointsV) {
        this.pointsV = pointsV;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", tourNum=" + tourNum +
                ", homeTeamId=" + homeTeamId +
                ", visitorTeamId=" + visitorTeamId +
                ", pointsH=" + pointsH +
                ", pointsV=" + pointsV +
                '}';
    }
}
