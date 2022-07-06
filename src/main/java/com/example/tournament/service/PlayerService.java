package com.example.tournament.service;

import com.example.tournament.domain.Player;
import com.example.tournament.domain.Team;
import com.example.tournament.dto.Mapper;
import com.example.tournament.dto.RequestPlayer;
import com.example.tournament.dto.ResponsePlayer;
import com.example.tournament.dto.ResponseTeam;
import com.example.tournament.repo.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    PlayerRepository playerRepo;
    Mapper mapper;
    public PlayerService(PlayerRepository playerRepo, Mapper mapper) {
        this.playerRepo = playerRepo;
        this.mapper = mapper;
    }

    public ResponsePlayer getPlayer(Integer id){
        return mapper.toDto(playerRepo.findById(id).get());
    }
    public Player savePlayer(RequestPlayer reqPlayer){
        Player player = mapper.toPlayer(reqPlayer);
        return playerRepo.save(player);
    }

    public void deletePlayer(Integer id){
        playerRepo.deleteById(id);
    }
    public Player updatePlayer(RequestPlayer reqPlayer){
        if(playerRepo.existsById(Integer.parseInt(reqPlayer.getPlayerId()))){
            Player player = playerRepo.findById(Integer.parseInt(reqPlayer.getPlayerId())).get();
            Player player1 = mapper.toPlayer(reqPlayer);
            playerRepo.save(player1);
            return player;
        }
        return null;
    }
    public List<ResponsePlayer> listPlayer(){
        List<Player> listPlayer =  playerRepo.findAll();
        List <ResponsePlayer> listResp = new ArrayList<>();
        for (Player p : listPlayer) {
            listResp.add(mapper.toDto(p));
        }
        return  listResp;
    }

}
