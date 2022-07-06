package com.example.tournament.controller;

import com.example.tournament.domain.Stat;
import com.example.tournament.dto.RequestStat;
import com.example.tournament.dto.ResponseStat;
import com.example.tournament.service.StatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StatController {
    StatService service;
    public StatController(StatService statService) {
        this.service = statService;
    }
    public StatService getStatService() { return service; }
    public void setStatService(StatService statService) { this.service = statService;  }
    @GetMapping("/stat/{id}")
    public ResponseStat getStat(@PathVariable Integer id){
        return service.getStat(id);
    }
    @GetMapping("/stat/list")
    public List<ResponseStat> getListStats(){
        return service.listStat();
    }
    @PostMapping("/stat")
    public Stat save(@RequestBody RequestStat reqStat){
        return service.saveStat(reqStat);
    }
    @DeleteMapping("/stat/{id}")
    public String delete(@PathVariable Integer id){
        service.deleteStat(id);
        return "Deleted";
    }
    @PutMapping("/stat")
    public Stat update(@RequestBody RequestStat reqStat){
        return service.updateStat(reqStat);
    }
}
