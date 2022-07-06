package com.example.tournament.service;
import com.example.tournament.domain.Stat;
import com.example.tournament.dto.Mapper;
import com.example.tournament.dto.RequestStat;
import com.example.tournament.dto.ResponseStat;
import com.example.tournament.repo.StatRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatService {
    StatRepository statRepo;
    Mapper mapper;

    public StatService(StatRepository statRepo, Mapper mapper) {
        this.statRepo = statRepo;
        this.mapper = mapper;
    }
    public ResponseStat getStat(Integer id){
        return mapper.toDto(statRepo.findById(id).get());
    }

    public Stat saveStat(RequestStat reqStat){
        Stat stat = mapper.toStat(reqStat);
        return statRepo.save(stat);
    }
    public void deleteStat(Integer id){
        statRepo.deleteById(id);
    }
    public Stat updateStat(RequestStat reqStat){
        if(statRepo.existsById(Integer.parseInt(reqStat.getStatId()))){
            Stat s1 = statRepo.findById(Integer.parseInt(reqStat.getStatId())).get();
            Stat s = mapper.toStat(reqStat);
            statRepo.save(s);
            return s1;
        }
        return null;
    }
    public List<ResponseStat> listStat(){
        List<Stat> listStat =  statRepo.findAll();
        List <ResponseStat> listResp = new ArrayList<>();
        for (Stat s : listStat) {
            listResp.add(mapper.toDto(s));
        }
        return listResp;
    }


}
