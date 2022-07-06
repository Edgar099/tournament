package com.example.tournament.service;

import com.example.tournament.domain.Coach;
import com.example.tournament.domain.Team;
import com.example.tournament.dto.Mapper;
import com.example.tournament.dto.RequestCoach;
import com.example.tournament.dto.RequestTeam;
import com.example.tournament.dto.ResponseCoach;
import com.example.tournament.repo.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CoachService {
    final CoachRepository coachRepository;
    Mapper mapper;
    CoachService(CoachRepository coachRepository, Mapper mapper){
        this.coachRepository = coachRepository;
        this.mapper = mapper;
    }


    public ResponseCoach getCoach(Integer id){
        return mapper.toDto(coachRepository.findById(id).get());
    }
    public Coach saveCoach(RequestCoach  requestCoach){
        Coach coach = mapper.toCoach(requestCoach);
        return coachRepository.save(coach);
    }
    public void deleteCoach(Integer id){
        if(coachRepository.existsById(id)){
            coachRepository.deleteById(id);
        }
    }
    public Coach updateCoach(RequestCoach reqCoach){
        if(coachRepository.existsById(Integer.parseInt(reqCoach.getCoachId()))){
            Coach coach = mapper.toCoach(reqCoach);
            Coach coach1 = coachRepository.findById(Integer.parseInt(reqCoach.getCoachId())).get();
            coachRepository.save(coach);
            return coach1;


        }
        return null;
    }

    public List<ResponseCoach> listCoach(){
        List<ResponseCoach> list = new ArrayList<>();
        List<Coach> coachList = coachRepository.findAll();
        for (Coach coach : coachList)
            list.add(new ResponseCoach(coach.getFirstName(),
                    coach.getLastName()));
        return list;
    }

}
