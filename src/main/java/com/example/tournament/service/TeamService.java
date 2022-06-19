package com.example.tournament.service;

import com.example.tournament.domain.Team;
import com.example.tournament.repo.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
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
        try{
            if(teamRepository.existsById(id)){
                teamRepository.delete(getTeam(id));
            }
        }
        catch (RuntimeException ignored){
        }


    }
    public Team  updateTeam(Team team){
        try {
            if (teamRepository.existsById(team.getIdTeam())) {
                Team team1 = getTeam(team.getIdTeam());
                teamRepository.save(team);
                return team1;
            }
        }
        catch (RuntimeException ignored){
        }
        return null;
    }
    public List<Team> listTeam(){
        return teamRepository.findAll();
    }

}
