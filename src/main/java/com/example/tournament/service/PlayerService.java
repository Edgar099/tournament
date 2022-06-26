package com.example.tournament.service;

import com.example.tournament.domain.Player;
import com.example.tournament.repo.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    PlayerRepository playerRepo;
    public PlayerService(PlayerRepository playerRepo) {
        this.playerRepo = playerRepo;
    }
    public Player getPlayer(Integer id){
        return playerRepo.findById(id).get();
    }
    public Player savePlayer(Player p){
        return playerRepo.save(p);
    }
    public List<Player> getListPlayers(){
        return playerRepo.findAll();
    }
    public void deletePlayer(Integer id){
        playerRepo.deleteById(id);
    }
    public Player updatePlayer(Player p){
        if(playerRepo.existsById(p.getPlayerId())){
            Player p1 = getPlayer(p.getPlayerId());
            playerRepo.save(p);
            return p1;
        }
        return null;
    }


}
