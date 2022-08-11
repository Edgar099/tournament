package com.example.tournament.controller;
import com.example.tournament.domain.Game;
import com.example.tournament.dto.RequestGame;
import com.example.tournament.dto.ResponseGame;
import com.example.tournament.service.GameService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class GameController {
    GameService service;
    public GameController(GameService gameServ) {
        this.service = gameServ;
    }
    public GameService getGameServ() {
        return service;
    }
    public void setGameServ(GameService gameServ) {
        this.service = gameServ;
    }

    @GetMapping("/game/{id}")
    public Object find(@PathVariable Integer id){
        return service.getGame(id);
    }
    @GetMapping("/game/list")
    public  List<ResponseGame> findAllGames(){
        return service.listGame();
    }
    @PostMapping("/game")
    public Game save (@RequestBody RequestGame reqGame){
        return service.saveGame(reqGame);
    }
    @DeleteMapping("/game/{id}")
    public String delete(@PathVariable Integer id){
        return service.deleteGame(id);
    }
    @PutMapping("/game")
    public Object update(@RequestBody RequestGame reqGame){
        return service.updateGame(reqGame);
    }

 }
