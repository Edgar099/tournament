package com.example.tournament.service;
import com.example.tournament.domain.Coach;
import com.example.tournament.domain.Team;
import com.example.tournament.dto.Mapper;
import com.example.tournament.dto.RequestTeam;
import com.example.tournament.dto.ResponseTeam;
import com.example.tournament.repo.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TeamService {
    private final TeamRepository teamRepo;
    private final Mapper mapper;

    public TeamService(TeamRepository teamRepo, Mapper mapper) {
        this.teamRepo = teamRepo;
        this.mapper = mapper;
    }

    public TeamRepository getTeamRepo() {
        return teamRepo;
    }

    public Object getTeam(Integer id) {
        try{
            return mapper.toDto(teamRepo.findById(id).get());
        }
        catch (NoSuchElementException ex){
            return String.format("Team doesn't exist with such id: %d",id);
        }

    }
    public Team saveTeam(RequestTeam reqTeam){
        Team team = mapper.toTeam(reqTeam);
        return teamRepo.save(team);
    }
    public String  deleteTeam(Integer id){
        try{
            teamRepo.deleteById(id);
            return String.format("Team with id = %d is deleted",id);

        }
        catch (RuntimeException ex){
            return String.format("Team doesn't exists with such id: %d ", id);
        }
    }
    public Object updateTeam(RequestTeam reqTeam){
        try{
            Team team = mapper.toTeam(reqTeam);
            Team team1 = teamRepo.findById(Integer.parseInt(reqTeam.getTeamId())).
                    orElseThrow(()->new NoSuchElementException("No such elements"));
            teamRepo.save(team);
            return team1;
        }
        catch (NoSuchElementException ex){
            return String.format("Team doesn't exists with such id: %s ", reqTeam.getTeamId());
        }
    }
    public List<ResponseTeam> listTeam(){
        List<Team> listT =  teamRepo.findAll();
        List <ResponseTeam> listR = new ArrayList<>();
        for (Team team : listT) {
            listR.add(mapper.toDto(team));
        }
        return  listR;
    }

}
