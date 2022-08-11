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
import java.util.NoSuchElementException;

@Service
public class GameService {
    GameRepository gameRepo;
    Mapper mapper;

    public GameService(GameRepository gameRepo, Mapper mapper) {
        this.gameRepo = gameRepo;
        this.mapper = mapper;
    }

    public Object getGame(Integer id){
        try{
            return mapper.toDto(gameRepo.findById(id).get());
        }
        catch(NoSuchElementException ex){
            return String.format("Can't find game with such id: %d",id);
        }

    }

    public Game saveGame(RequestGame reqGame){
        Game game = mapper.toGame(reqGame);
        return gameRepo.save(game);
    }
    public String deleteGame(Integer id){
        try{
            gameRepo.deleteById(id);
            return String.format("Game with id %d deleted", id);
        }
        catch (RuntimeException ex){
            return String.format("Can't find game with such id: %d",id);
        }

    }
    public Object updateGame(RequestGame reqGame){
        try {
            Game game = gameRepo.findById(Integer.parseInt(reqGame.getGameId()))
                    .orElseThrow(NoSuchElementException::new);
            Game game1 = mapper.toGame(reqGame);
            gameRepo.save(game1);
            return game;
        }
        catch (NoSuchElementException ex){
            return String.format("Can't find game with such id: %s",reqGame.getGameId());
        }
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
