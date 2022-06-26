package com.example.tournament.service;

import com.example.tournament.domain.Stat;
import com.example.tournament.repo.StatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatService {
    StatRepository statRepo;
    public StatService(StatRepository statRepo) {
        this.statRepo = statRepo;
    }
    public Stat getStat(Integer id){
        return statRepo.findById(id).get();
    }
    public List<Stat> getListStat(){
        return statRepo.findAll();
    }
    public Stat saveStat(Stat s){
        return statRepo.save(s);
    }
    public void deleteStat(Integer id){
        statRepo.deleteById(id);
    }
    public Stat updateStat(Stat s){
        if(statRepo.existsById(s.getStatId())){
            Stat s1 = getStat(s.getStatId());
            statRepo.save(s);
            return s1;
        }
        return null;
    }



}
