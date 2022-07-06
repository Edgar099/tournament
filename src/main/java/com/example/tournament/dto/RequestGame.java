package com.example.tournament.dto;

public class RequestGame {
    private String gameId;
    private String tourNum;
    private String homeTeamId;
    private String pointsHomeTeam;
    private String visitTeamId;
    private String pointsVisitTeam;

    public RequestGame(String tourNum, String homeTeamId, String pointsHomeTeam, String visitTeamId, String pointsVisitTeam) {
        this.tourNum = tourNum;
        this.homeTeamId = homeTeamId;
        this.pointsHomeTeam = pointsHomeTeam;
        this.visitTeamId = visitTeamId;
        this.pointsVisitTeam = pointsVisitTeam;
    }

//    public RequestGame(String gameId, String tourNum, String homeTeamId, String pointsHomeTeam, String visitTeamId, String pointsVisitTeam) {
//        this.gameId = gameId;
//        this.tourNum = tourNum;
//        this.homeTeamId = homeTeamId;
//        this.pointsHomeTeam = pointsHomeTeam;
//        this.visitTeamId = visitTeamId;
//        this.pointsVisitTeam = pointsVisitTeam;
//    }

    public RequestGame() {
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getTourNum() {
        return tourNum;
    }

    public void setTourNum(String tourNum) {
        this.tourNum = tourNum;
    }

    public String getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(String homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public String getPointsHomeTeam() {
        return pointsHomeTeam;
    }

    public void setPointsHomeTeam(String pointsHomeTeam) {
        this.pointsHomeTeam = pointsHomeTeam;
    }

    public String getVisitTeamId() {
        return visitTeamId;
    }

    public void setVisitTeamId(String visitTeamId) {
        this.visitTeamId = visitTeamId;
    }

    public String getPointsVisitTeam() {
        return pointsVisitTeam;
    }

    public void setPointsVisitTeam(String pointsVisitTeam) {
        this.pointsVisitTeam = pointsVisitTeam;
    }

    @Override
    public String toString() {
        return "RequestGame{" +
                "tourNum='" + tourNum + '\'' +
                ", homeTeamId='" + homeTeamId + '\'' +
                ", pointsHomeTeam='" + pointsHomeTeam + '\'' +
                ", visitTeamId='" + visitTeamId + '\'' +
                ", pointsVisitTeam='" + pointsVisitTeam + '\'' +
                '}';
    }
}
