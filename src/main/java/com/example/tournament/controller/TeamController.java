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

    @GetMapping("/teams/{id}")
    public ResponseEntity<Team> findTeam(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getTeam(id));
    }

    @GetMapping("/teams")
    public ResponseEntity<List<Team>> findAllTeams() {
        return ResponseEntity.ok(service.listTeam());
    }

    @PostMapping("/teams")
    public ResponseEntity<Team> save(@RequestBody  Team team) {
        return ResponseEntity.ok(service.saveTeam(team));
    }
    @DeleteMapping( "/teams/{id}")
    public ResponseEntity<Team> delete(@PathVariable Integer id) {
        service.deleteTeam(id);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping("/teams")
    public ResponseEntity<Team> update( @RequestBody  Team team){
        return ResponseEntity.ok(service.updateTeam(team));
    }
}
