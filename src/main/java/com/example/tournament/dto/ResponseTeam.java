package com.example.tournament.dto;

public class ResponseTeam {
    private String teamName;
    private String city;
    public ResponseTeam(String teamName, String city) {
        this.teamName = teamName;
        this.city = city;
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
        return "ResponseTeam{" +
                "teamName='" + teamName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
