package com.example.tournament.controller;

import com.example.tournament.domain.Player;
import com.example.tournament.dto.RequestPlayer;
import com.example.tournament.dto.ResponsePlayer;
import com.example.tournament.service.PlayerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PlayerController {
    PlayerService service;
    public PlayerController(PlayerService playerServ) {
        this.service = playerServ;
    }
    public PlayerService getService() {
        return service;
    }
    public void setService(PlayerService playerServ) {
        this.service = playerServ;
    }

    @GetMapping("/player/{id}")
    public Object getPlayer(@PathVariable Integer id){
        return service.getPlayer(id);
    }
    @GetMapping("/player/list")
    public List<ResponsePlayer> getListPlayers(){
        return service.listPlayer();
    }
    @PostMapping("/player")
    public Player savePlayer(@RequestBody RequestPlayer reqPlayer){
        return service.savePlayer(reqPlayer);
    }
    @DeleteMapping("/player/{id}")
    public String deletePlayer(@PathVariable Integer id){
        return service.deletePlayer(id);
    }
    @PutMapping("/player")
    public Object updatePlayer(@RequestBody RequestPlayer reqPlayer){
        return service.updatePlayer(reqPlayer);
    }

}
