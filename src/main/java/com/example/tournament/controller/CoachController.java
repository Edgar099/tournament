package com.example.tournament.controller;

import com.example.tournament.domain.Coach;
import com.example.tournament.service.CoachService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoachController {
    private CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;

    }
    public CoachService getCoachService() {
        return coachService;
    }
    public void setCoachService(CoachService coachService) {
        this.coachService = coachService;
    }
    @GetMapping("/coach/{id}")
    public ResponseEntity<Coach> findCoach(@PathVariable Integer id){
        return ResponseEntity.ok(coachService.getCoach(id));
    }
    @GetMapping("/coaches")
    public ResponseEntity<List<Coach>> findAllCoaches(){
        return ResponseEntity.ok(coachService.listCoach());
    }
    @PostMapping("/coach")
    public ResponseEntity<Coach> saveCoach(@RequestBody Coach coach){
        return ResponseEntity.ok(coachService.saveCoach(coach));
    }
    @DeleteMapping("/coach/{id}")
    public void deleteCoach (@PathVariable Integer id){
        coachService.deleteCoach(id);
    }
    @PutMapping("/coach")
    public ResponseEntity<Coach> updateCoach (@RequestBody Coach coach){
        return  ResponseEntity.ok(coachService.updateCoach(coach));
    }


}
