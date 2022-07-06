package com.example.tournament.dto;

public class ResponsePlayer {
    private String firstName;
    private String lastName;
    private String teamName;
    private String height;
    private String weight;
    private String positionOnCourt;
    private String age;

    public ResponsePlayer(String firstName, String lastName, String teamName, String height, String weight, String age, String positionOnCourt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamName = teamName;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.positionOnCourt = positionOnCourt;
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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPositionOnCourt() {
        return positionOnCourt;
    }

    public void setPositionOnCourt(String positionOnCourt) {
        this.positionOnCourt = positionOnCourt;
    }

    @Override
    public String toString() {
        return "ResponsePlayer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", teamName='" + teamName + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", age='" + age + '\'' +
                ", positionOnCourt='" + positionOnCourt + '\'' +
                '}';
    }
}
