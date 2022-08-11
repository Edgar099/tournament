package com.example.tournament.controller;

import com.example.tournament.domain.Coach;
import com.example.tournament.dto.RequestCoach;
import com.example.tournament.dto.ResponseCoach;
import com.example.tournament.service.CoachService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@ControllerAdvice
@RestController
public class CoachController {
    private final CoachService service;

    public CoachController(CoachService coachService) {
        this.service = coachService;
    }
    @GetMapping("/coach/{id}")
    public Object getCoach(@PathVariable Integer id){
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
        return service.deleteCoach(id);
    }
    @PutMapping("/coach")
    public Object updateCoach(@RequestBody RequestCoach coach){
        return service.updateCoach(coach);
    }


}
