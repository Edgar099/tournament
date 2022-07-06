package com.example.tournament.controller;
import com.example.tournament.domain.Team;
import com.example.tournament.dto.RequestTeam;
import com.example.tournament.dto.ResponseTeam;
import com.example.tournament.service.TeamService;
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

    @GetMapping("/team/{id}")
    public ResponseTeam findTeam(@PathVariable Integer id) {
        return service.getTeam(id);
    }

    @GetMapping("/team/list")
    public List<ResponseTeam> findAllTeams() {
        return service.listTeam();
    }

    @PostMapping("/team")
    public Team saveTeam(@RequestBody RequestTeam reqTeam){
        return service.saveTeam(reqTeam);
    }
    @DeleteMapping( "/team/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteTeam(id);
        return "This Team deleted";
    }

    @PutMapping("/team")
    public Team update(@RequestBody  RequestTeam  reqTeam){
        return service.updateTeam(reqTeam);
    }
}
