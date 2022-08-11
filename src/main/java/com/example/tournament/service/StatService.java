package com.example.tournament.service;
import com.example.tournament.domain.Stat;
import com.example.tournament.dto.Mapper;
import com.example.tournament.dto.RequestStat;
import com.example.tournament.dto.ResponseStat;
import com.example.tournament.repo.StatRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StatService {
    StatRepository statRepo;
    Mapper mapper;

    public StatService(StatRepository statRepo, Mapper mapper) {
        this.statRepo = statRepo;
        this.mapper = mapper;
    }
    public Object getStat(Integer id){
        try{
            return mapper.toDto(statRepo.findById(id).get());
        }
        catch (NoSuchElementException ex){
            return String.format("Can't find statistics with such id: %d ", id);
        }
    }

    public Stat saveStat(RequestStat reqStat){
        Stat stat = mapper.toStat(reqStat);
        return statRepo.save(stat);
    }
    public String deleteStat(Integer id){
        try{
            statRepo.deleteById(id);
            return String.format("Statistics with id %d deleted", id);
        }
        catch (RuntimeException ex){
            return String.format("Can't find statistics with such id: %d ", id);
        }
    }
    public Object updateStat(RequestStat reqStat){
        try{
            Stat s1 = statRepo.findById(Integer.parseInt(reqStat.getStatId())).get();
            Stat s = mapper.toStat(reqStat);
            statRepo.save(s);
            return s1;
        }
        catch(RuntimeException ex){
            return String.format("Can't find statistics with such id: %s ", reqStat.getStatId());
        }
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
