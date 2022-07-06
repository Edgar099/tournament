package com.example.tournament.dto;

public class RequestCoach {
    private String coachId;
    private String firstName;
    private String lastName;

    public RequestCoach() {
    }
    public RequestCoach(String coachId, String firstName, String lastName) {
        this.coachId = coachId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
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
    @Override
    public String toString() {
        return "RequestCoach{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
