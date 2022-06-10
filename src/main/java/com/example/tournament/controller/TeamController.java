package com.example.tournament.controller;
import com.example.tournament.domain.Team;
import com.example.tournament.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {
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

    @GetMapping("/{id}")
    public ResponseEntity<Team> findTeam(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getTeam(id));
    }

    @GetMapping("/teams")
    public ResponseEntity<List<Team>> findAllTeams() {
        return ResponseEntity.ok(service.listTeam());
    }

    @PostMapping("/save/{id}")
    public ResponseEntity<Team> save(@RequestBody  Team team, @PathVariable Integer id) {
        team.setIdTeam(id);
        return ResponseEntity.ok(service.saveTeam(team));
    }
    @DeleteMapping( "/delete/{id}")
    public ResponseEntity<Team> delete(@PathVariable Integer id) {
        service.deleteTeam(id);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Team> update(@PathVariable Integer id, @RequestBody  Team team){
        team.setIdTeam(id);
        return ResponseEntity.ok(service.updateTeam(team));
    }
}
