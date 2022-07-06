package com.example.tournament.service;

import com.example.tournament.domain.Game;
import com.example.tournament.domain.Team;
import com.example.tournament.dto.Mapper;
import com.example.tournament.dto.RequestGame;
import com.example.tournament.dto.RequestTeam;
import com.example.tournament.dto.ResponseGame;
import com.example.tournament.repo.GameRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    GameRepository gameRepo;
    Mapper mapper;

    public GameService(GameRepository gameRepo, Mapper mapper) {
        this.gameRepo = gameRepo;
        this.mapper = mapper;
    }

    public ResponseGame getGame(Integer id){
        return mapper.toDto(gameRepo.findById(id).get());
    }

    public Game saveGame(RequestGame reqGame){
        Game game = mapper.toGame(reqGame);
        return gameRepo.save(game);
    }
    public void deleteGame(Integer id){
        gameRepo.deleteById(id);
    }
    public Game updateGame(RequestGame reqGame){
        if (gameRepo.existsById(Integer.parseInt(reqGame.getGameId()))) {
            Game game = gameRepo.findById(Integer.parseInt(reqGame.getGameId())).get();
            Game game1 = mapper.toGame(reqGame);
            gameRepo.save(game1);
            return game;
        }
        return null;
    }
    public List<ResponseGame> listGame(){
        List<Game> listGame =  gameRepo.findAll();
        List<ResponseGame> listResp = new ArrayList<>();
        for(Game game: listGame){
            listResp.add(mapper.toDto(game));
        }
        return  listResp;
    }
}
