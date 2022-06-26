package com.example.tournament.domain;

import javax.persistence.*;

@Entity
@Table
public class Stat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stat_id")
    private Integer statId;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player playerId;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private Game gameId;

    @Column(name = "minutes_on_court")
    private Integer minutesOnCourt;
    @Column(name = "all_free_throws")
    private Integer allFreeThrows;
    @Column(name = "exact_free_throws")
    private Integer exactFreeThrows;
    @Column(name = "all_2_throws")
    private Integer all2Throws;
    @Column(name = "exact_2_throws")
    private Integer exact2Throws;
    @Column(name = "all_3_throws")
    private Integer all3Throws;
    @Column(name = "exact_3_throws")
    private Integer exact3Throws;
    @Column(name = "assists")
    private Integer assists;
    @Column(name = "steals")
    private Integer steals;
    @Column(name = "blocks")
    private Integer blocks;

    public Stat(Integer statId, Game gameId, Player playerId, Integer minutesOnCourt, Integer allFreeThrows, Integer exactFreeThrows, Integer all2Throws, Integer exact2Throws, Integer all3Throws, Integer exact3Throws, Integer assists, Integer steals, Integer blocks) {
        this.statId = statId;
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
    public Stat() {
    }

    public Integer getStatId() {        return statId;    }
    public void setStatId(Integer statId) {        this.statId = statId;    }

    public Game getGameId() {        return gameId;    }
    public void setGameId(Game gameId) {        this.gameId = gameId;    }

    public Player getPlayerId() {        return playerId;    }
    public void setPlayerId(Player playerId) {        this.playerId = playerId;    }

    public Integer getMinutesOnCourt() {        return minutesOnCourt;    }
    public void setMinutesOnCourt(Integer minutesOnCourt) {
        this.minutesOnCourt = minutesOnCourt;
    }

    public Integer getAllFreeThrows() {
        return allFreeThrows;
    }
    public void setAllFreeThrows(Integer allFreeThrows) {
        this.allFreeThrows = allFreeThrows;
    }

    public Integer getExactFreeThrows() {
        return exactFreeThrows;
    }
    public void setExactFreeThrows(Integer exactFreeThrows) {
        this.exactFreeThrows = exactFreeThrows;
    }

    public Integer getAll2Throws() {
        return all2Throws;
    }
    public void setAll2Throws(Integer all2Throws) {
        this.all2Throws = all2Throws;
    }

    public Integer getExact2Throws() {
        return exact2Throws;
    }
    public void setExact2Throws(Integer exact2Throws) {
        this.exact2Throws = exact2Throws;
    }

    public Integer getAll3Throws() {
        return all3Throws;
    }
    public void setAll3Throws(Integer all3Throws) {
        this.all3Throws = all3Throws;
    }

    public Integer getExact3Throws() {
        return exact3Throws;
    }
    public void setExact3Throws(Integer exact3Throws) {
        this.exact3Throws = exact3Throws;
    }

    public Integer getAssists() {
        return assists;
    }
    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getSteals() {
        return steals;
    }
    public void setSteals(Integer steals) {
        this.steals = steals;
    }

    public Integer getBlocks() {
        return blocks;
    }
    public void setBlocks(Integer blocks) {
        this.blocks = blocks;
    }

    @Override
    public String toString() {
        return "Stat{" +
                "statId=" + statId + ", gameId=" + gameId + ", playerId=" + playerId +
                ", minutesOnCourt=" + minutesOnCourt +  ", allFreeThrows=" + allFreeThrows +
                ", exactFreeThrows=" + exactFreeThrows + ", all2Throws=" + all2Throws +
                ", exact2Throws=" + exact2Throws +  ", all3Throws=" + all3Throws +
                ", exact3Throws=" + exact3Throws +  ", assists=" + assists +
                ", steals=" + steals + ", blocks=" + blocks +
                '}';
    }
}
