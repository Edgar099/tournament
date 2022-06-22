package com.example.tournament.service;

import com.example.tournament.domain.Game;
import com.example.tournament.repo.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    GameRepository gameRepo;
    public GameService(GameRepository gameRepo) {
        this.gameRepo = gameRepo;
    }
    public Game getGame(Integer id){
        return gameRepo.findById(id).get();
    }
    public Game saveGame(Game game){
        return gameRepo.save(game);
    }
    public void deleteGame(Integer id){
        if(gameRepo.existsById(id)){
            gameRepo.delete(getGame(id));
        }
    }
    public Game update(Game game){
        if(gameRepo.existsById(game.getGameId())){
            Game game1 = getGame(game.getGameId());
            gameRepo.save(game);
            return game1;
        }
        return null;
    }
    public List<Game> listGame(){
        return gameRepo.findAll();
    }
}
