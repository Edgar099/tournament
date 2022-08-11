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
import java.util.NoSuchElementException;

@Service
public class PlayerService {
    PlayerRepository playerRepo;
    Mapper mapper;
    public PlayerService(PlayerRepository playerRepo, Mapper mapper) {
        this.playerRepo = playerRepo;
        this.mapper = mapper;
    }

    public Object getPlayer(Integer id){
        try{
            return mapper.toDto(playerRepo.findById(id).get());
        }
        catch(NoSuchElementException ex){
            return String.format("Can't find player with such id: %d ", id);
        }

    }
    public Player savePlayer(RequestPlayer reqPlayer){
        Player player = mapper.toPlayer(reqPlayer);
        return playerRepo.save(player);
    }

    public String deletePlayer(Integer id){
        try{
            playerRepo.deleteById(id);
            return String.format("Player with id %d deleted", id);
        }
        catch (RuntimeException ex){
            return String.format("Can't find player with such id: %d ", id);
        }
    }
    public Object updatePlayer(RequestPlayer reqPlayer){
        try{
            Player player = playerRepo.findById(Integer.parseInt(reqPlayer.getPlayerId())).get();
            Player player1 = mapper.toPlayer(reqPlayer);
            playerRepo.save(player1);
            return player;
        }
        catch (RuntimeException ex){
            return String.format("Can't find player with such id: %s ", reqPlayer.getPlayerId());
        }

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
