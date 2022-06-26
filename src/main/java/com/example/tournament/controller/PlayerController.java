package com.example.tournament.controller;

import com.example.tournament.domain.Player;
import com.example.tournament.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
    PlayerService playerServ;
    public PlayerController(PlayerService playerServ) {
        this.playerServ = playerServ;
    }
    public PlayerService getPlayerServ() {
        return playerServ;
    }
    public void setPlayerServ(PlayerService playerServ) {
        this.playerServ = playerServ;
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable Integer id){
        return ResponseEntity.ok(playerServ.getPlayer(id));
    }
    @GetMapping("/players")
    public ResponseEntity<List<Player>> getListPlayers(){
        return ResponseEntity.ok(playerServ.getListPlayers());
    }
    @PostMapping("/player")
    public ResponseEntity<Player> savePlayer(Player p){
        return ResponseEntity.ok(playerServ.savePlayer(p));
    }
    @DeleteMapping("/player/{id}")
    public void deletePlayer(@PathVariable Integer id){
        playerServ.deletePlayer(id);
    }
    @PutMapping("/player")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player p){
        return ResponseEntity.ok(playerServ.updatePlayer(p));
    }

}
