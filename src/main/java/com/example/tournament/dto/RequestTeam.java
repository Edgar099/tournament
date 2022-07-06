package com.example.tournament.dto;
public class RequestTeam {
    String teamId;
    String coachId;
    String teamName;
    String city;

    public RequestTeam(String teamId, String coachId, String teamName, String city) {
        this.teamId = teamId;
        this.coachId = coachId;
        this.teamName = teamName;
        this.city = city;
    }

    public RequestTeam(String coachId, String teamName, String city) {
        this.coachId = coachId;
        this.teamName = teamName;
        this.city = city;
    }

    public RequestTeam() {
    }
    public String getTeamId() {
        return teamId;
    }
    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
    public String getCoachId() {
        return coachId;
    }
    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String firstName) {
        this.teamName = firstName;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String lastName) {
        this.city = lastName;
    }
    @Override
    public String toString() {
        return "RequestTeam{" +
                "teamId='" + teamId + '\'' +
                ", coachId='" + coachId + '\'' +
                ", firstName='" + teamName + '\'' +
                ", lastName='" + city + '\'' +
                '}';
    }
}
