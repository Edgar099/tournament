package com.example.tournament.controller;

import com.example.tournament.domain.Stat;
import com.example.tournament.service.StatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StatController {
    StatService statService;
    public StatController(StatService statService) {
        this.statService = statService;
    }
    public StatService getStatService() { return statService; }
    public void setStatService(StatService statService) { this.statService = statService;  }
    @GetMapping("/stat/{id}")
    public ResponseEntity<Stat> getStat(@PathVariable Integer id){
        return ResponseEntity.ok(statService.getStat(id));
    }
    @GetMapping("/stats")
    public ResponseEntity<List<Stat>> getListStats(){
        return ResponseEntity.ok(statService.getListStat());
    }
    @PostMapping("/stat")
    public ResponseEntity<Stat> save(Stat s){
        return ResponseEntity.ok(statService.saveStat(s));
    }
    @DeleteMapping("/stat/{id}")
    public void delete(@PathVariable Integer id){
        statService.deleteStat(id);
    }
    @PutMapping("/stat")
    public ResponseEntity<Stat> update(Stat s){
        return ResponseEntity.ok(statService.updateStat(s));
    }
}
