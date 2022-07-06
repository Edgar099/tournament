package com.example.tournament.dto;

public class ResponseGame {
    private String tourNum;
    private String homeTeamName;
    private String pointsHomeTeam;
    private String visitorTeamName;
    private String pointsVisitorTeam;

    public ResponseGame(String tourNum, String homeTeamName, String pointsHomeTeam, String visitorTeamName, String pointsVisitorTeam) {
        this.tourNum = tourNum;
        this.homeTeamName = homeTeamName;
        this.pointsHomeTeam = pointsHomeTeam;
        this.visitorTeamName = visitorTeamName;
        this.pointsVisitorTeam = pointsVisitorTeam;
    }
    public String getTourNum() {
        return tourNum;
    }
    public void setTourNum(String tourNum) {
        this.tourNum = tourNum;
    }
    public String getHomeTeamName() {
        return homeTeamName;
    }
    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }
    public String getPointsHomeTeam() {
        return pointsHomeTeam;
    }
    public void setPointsHomeTeam(String pointsHomeTeam) {
        this.pointsHomeTeam = pointsHomeTeam;
    }
    public String getVisitorTeamName() {
        return visitorTeamName;
    }
    public void setVisitorTeamName(String visitorTeamName) {
        this.visitorTeamName = visitorTeamName;
    }
    public String getPointsVisitorTeam() {
        return pointsVisitorTeam;
    }
    public void setPointsVisitorTeam(String pointsVisitorTeam) {
        this.pointsVisitorTeam = pointsVisitorTeam;
    }
    @Override
    public String toString() {
        return "ResponseGame{" +
                "tourNum='" + tourNum + '\'' +
                ", homeTeamName='" + homeTeamName + '\'' +
                ", pointsHomeTeam='" + pointsHomeTeam + '\'' +
                ", visitorTeamName='" + visitorTeamName + '\'' +
                ", pointsVisitorTeam='" + pointsVisitorTeam + '\'' +
                '}';
    }
}
