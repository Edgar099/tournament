package com.example.tournament.controller;

import com.example.tournament.domain.Coach;
import com.example.tournament.dto.RequestCoach;
import com.example.tournament.dto.ResponseCoach;
import com.example.tournament.service.CoachService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CoachController {
    private final CoachService service;

    public CoachController(CoachService coachService) {
        this.service = coachService;
    }
    @GetMapping("/coach/{id}")
    public ResponseCoach getCoach(@PathVariable Integer id){
        return service.getCoach(id);
    }
    @GetMapping("/coach/list")
    public List<ResponseCoach> getListCoaches(){
        return service.listCoach();
    }
    @PostMapping("/coach")
    public Coach saveCoach(@RequestBody RequestCoach coach){
        return service.saveCoach(coach);
    }
    @DeleteMapping("/coach/{id}")
    public String deleteCoach(@PathVariable Integer id){
        service.deleteCoach(id);
        return "Deleted";
    }
    @PutMapping("/coach")
    public Coach updateCoach(@RequestBody RequestCoach coach){
        return service.updateCoach(coach);
    }


}
