package com.example.tournament.dto;

public class RequestPlayer {
    private String playerId;
    private String teamId;
    private String firstName;
    private String lastName;
    private String age;
    private String height;
    private String weight;
    private String positionOnCourt;
    private String numOfGames;

    public RequestPlayer(String teamId, String firstName, String lastName, String age, String height, String weight, String positionOnCourt, String numOfGames) {
        this.teamId = teamId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.positionOnCourt = positionOnCourt;
        this.numOfGames = numOfGames;
    }

    public RequestPlayer(String playerId, String teamId, String firstName, String lastName, String age, String height, String weight, String positionOnCourt, String numOfGames) {
        this.playerId = playerId;
        this.teamId = teamId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.positionOnCourt = positionOnCourt;
        this.numOfGames = numOfGames;
    }

    public RequestPlayer() {
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPositionOnCourt() {
        return positionOnCourt;
    }

    public void setPositionOnCourt(String positionOnCourt) {
        this.positionOnCourt = positionOnCourt;
    }

    public String getNumOfGames() {
        return numOfGames;
    }

    public void setNumOfGames(String numOfGames) {
        this.numOfGames = numOfGames;
    }

    @Override
    public String toString() {
        return "RequestPlayer{" +
                "playerId='" + playerId + '\'' +
                ", teamId='" + teamId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", positionOnCourt='" + positionOnCourt + '\'' +
                ", numOfGames='" + numOfGames + '\'' +
                '}';
    }
}
