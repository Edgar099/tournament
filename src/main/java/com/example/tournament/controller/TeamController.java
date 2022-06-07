package com.example.tournament.controller;

import com.example.tournament.domain.Team;
import com.example.tournament.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    private TeamService service;

    public TeamController(TeamService service) {
        this.service = service;
    }

    public TeamService getService() {
        return service;
    }

    public void setService(TeamService service) {
        this.service = service;
    }
    @GetMapping("/teams/{id}")
    public ResponseEntity<Team> findTeam(@PathVariable Integer id){
        return ResponseEntity.ok(service.getTeam(id));
    }
    @GetMapping("/teams")
    public ResponseEntity<List<Team>> findAllTeams(){
        return ResponseEntity.ok(service.listTeam());
    }
}
