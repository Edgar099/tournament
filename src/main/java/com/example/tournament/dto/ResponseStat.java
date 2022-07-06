package com.example.tournament.dto;

public class ResponseStat {
    private String gameId;
    private String playerId;
    private String minutesOnCourt;
    private String allFreeThrows;
    private String exactFreeThrows;
    private String all2Throws;
    private String exact2Throws;
    private String all3Throws;
    private String exact3Throws;
    private String assists;
    private String steals;
    private String blocks;

    public ResponseStat(String gameId, String playerId, String minutesOnCourt, String allFreeThrows, String exactFreeThrows, String all2Throws, String exact2Throws, String all3Throws, String exact3Throws, String assists, String steals, String blocks) {
        this.gameId = gameId;
        this.playerId = playerId;
        this.minutesOnCourt = minutesOnCourt;
        this.allFreeThrows = allFreeThrows;
        this.exactFreeThrows = exactFreeThrows;
        this.all2Throws = all2Throws;
        this.exact2Throws = exact2Throws;
        this.all3Throws = all3Throws;
        this.exact3Throws = exact3Throws;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getMinutesOnCourt() {
        return minutesOnCourt;
    }

    public void setMinutesOnCourt(String minutesOnCourt) {
        this.minutesOnCourt = minutesOnCourt;
    }

    public String getAllFreeThrows() {
        return allFreeThrows;
    }

    public void setAllFreeThrows(String allFreeThrows) {
        this.allFreeThrows = allFreeThrows;
    }

    public String getExactFreeThrows() {
        return exactFreeThrows;
    }

    public void setExactFreeThrows(String exactFreeThrows) {
        this.exactFreeThrows = exactFreeThrows;
    }

    public String getAll2Throws() {
        return all2Throws;
    }

    public void setAll2Throws(String all2Throws) {
        this.all2Throws = all2Throws;
    }

    public String getExact2Throws() {
        return exact2Throws;
    }

    public void setExact2Throws(String exact2Throws) {
        this.exact2Throws = exact2Throws;
    }

    public String getAll3Throws() {
        return all3Throws;
    }

    public void setAll3Throws(String all3Throws) {
        this.all3Throws = all3Throws;
    }

    public String getExact3Throws() {
        return exact3Throws;
    }

    public void setExact3Throws(String exact3Throws) {
        this.exact3Throws = exact3Throws;
    }

    public String getAssists() {
        return assists;
    }

    public void setAssists(String assists) {
        this.assists = assists;
    }

    public String getSteals() {
        return steals;
    }

    public void setSteals(String steals) {
        this.steals = steals;
    }

    public String getBlocks() {
        return blocks;
    }

    public void setBlocks(String blocks) {
        this.blocks = blocks;
    }

    @Override
    public String toString() {
        return "ResponseStat{" +
                "gameId='" + gameId + '\'' +
                ", playerId='" + playerId + '\'' +
                ", minutesOnCourt='" + minutesOnCourt + '\'' +
                ", allFreeThrow='" + allFreeThrows + '\'' +
                ", exactFreeThrow='" + exactFreeThrows + '\'' +
                ", all2Throws='" + all2Throws + '\'' +
                ", exact2Throws='" + exact2Throws + '\'' +
                ", all3Throws='" + all3Throws + '\'' +
                ", exact3Throws='" + exact3Throws + '\'' +
                ", assists='" + assists + '\'' +
                ", steals='" + steals + '\'' +
                ", blocks='" + blocks + '\'' +
                '}';
    }
}
