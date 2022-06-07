package com.example.tournament.service;

import com.example.tournament.domain.Team;
import com.example.tournament.repo.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    private final TeamRepository teamRepository;
    TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    public TeamRepository getTeamRepository() {
        return teamRepository;
    }

    public Team getTeam(Integer id){
        return teamRepository.findById(id).get();
    }
    public Team saveTeam(Team team){
        return teamRepository.save(team);
    }
    public void  deleteTeam(Integer id){
        teamRepository.delete(getTeam(id));
    }
    public Team  updateTeam(Team team){

        if(teamRepository.existsById(team.getId_team())){
            Team team1 = getTeam(team.getId_team());
            teamRepository.save(team);
            return team1;
        }
        return null;
    }
    public List<Team> listTeam(){
        return teamRepository.findAll();
    }
}
