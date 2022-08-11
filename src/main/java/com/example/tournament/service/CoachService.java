package com.example.tournament.service;

import com.example.tournament.domain.Coach;
import com.example.tournament.dto.Mapper;
import com.example.tournament.dto.RequestCoach;
import com.example.tournament.dto.ResponseCoach;
import com.example.tournament.repo.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CoachService {
    final CoachRepository coachRepository;
    Mapper mapper;
    CoachService(CoachRepository coachRepository, Mapper mapper){
        this.coachRepository = coachRepository;
        this.mapper = mapper;
    }
    public Object getCoach(Integer id){
        try{
            return mapper.toDto(coachRepository.findById(id).get());
        }
        catch (NoSuchElementException ex){
            return String.format("Can't find coach with such id: %d ", id);
        }
    }
    public Coach saveCoach(RequestCoach requestCoach){
        Coach coach = mapper.toCoach(requestCoach);
        return coachRepository.save(coach);
    }
    public String deleteCoach(Integer id){
        try{
            coachRepository.deleteById(id);
            return String.format("Coach with id = %d is deleted",id);

        }
        catch (RuntimeException ex){
            return String.format("Coach doesn't exists with such id: %d ", id);
        }
    }
    public Object updateCoach(RequestCoach reqCoach){
        try{
            Coach coach = mapper.toCoach(reqCoach);
            Coach coach1 = coachRepository.findById(Integer.parseInt(reqCoach.getCoachId())).
                    orElseThrow(()->new NoSuchElementException("No such elements"));
            coachRepository.save(coach);
            return coach1;
        }
        catch (NoSuchElementException ex){
            return String.format("Coach doesn't exists with such id: %s ", reqCoach.getCoachId());
        }


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
