package com.example.tournament.controller;

import com.example.tournament.domain.Coach;
import com.example.tournament.domain.Game;
import com.example.tournament.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {
    GameService gameServ;
    public GameController(GameService gameServ) {
        this.gameServ = gameServ;
    }
    public GameService getGameServ() {
        return gameServ;
    }
    public void setGameServ(GameService gameServ) {
        this.gameServ = gameServ;
    }

    @GetMapping("/game/{id}")
    public ResponseEntity<Game> find(@PathVariable Integer id){
        return ResponseEntity.ok(gameServ.getGame(id));
    }
    @GetMapping("/games")
    public ResponseEntity<List<Game>> findAllGames(){
        return ResponseEntity.ok(gameServ.listGame());
    }
    @PostMapping("/game")
    public ResponseEntity<Game> save (Game game){
        return ResponseEntity.ok(gameServ.saveGame(game));
    }
    @DeleteMapping("/game/{id}")
    public void delete(@PathVariable Integer id){
        gameServ.deleteGame(id);
    }
    @PutMapping("/game")
    public ResponseEntity<Game> update(@RequestBody Game game){
        return ResponseEntity.ok(gameServ.update(game));
    }

 }
