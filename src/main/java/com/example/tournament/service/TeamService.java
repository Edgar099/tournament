package com.example.tournament.service;
import com.example.tournament.domain.Team;
import com.example.tournament.dto.Mapper;
import com.example.tournament.dto.RequestTeam;
import com.example.tournament.dto.ResponseTeam;
import com.example.tournament.repo.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public ResponseTeam getTeam(Integer id){
        Team team = teamRepo.findById(id).get();
        return mapper.toDto(team);
    }
    public Team saveTeam(RequestTeam reqTeam){
        Team team = mapper.toTeam(reqTeam);
        return teamRepo.save(team);
    }
    public void  deleteTeam(Integer id){
        teamRepo.deleteById(id);
    }
    public Team updateTeam(RequestTeam reqTeam){
        if(teamRepo.existsById(Integer.parseInt(reqTeam.getTeamId()))){
            Team team1 = teamRepo.findById(Integer.parseInt(reqTeam.getTeamId())).get();
            Team team = mapper.toTeam(reqTeam);
            teamRepo.save(team);
            return team1;


        }
        return null;
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
