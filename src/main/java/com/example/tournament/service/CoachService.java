package com.example.tournament.service;

import com.example.tournament.domain.Coach;
import com.example.tournament.repo.CoachRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CoachService {
    final CoachRepository coachRepository;
    CoachService(CoachRepository coachRepository){
        this.coachRepository = coachRepository;
    }


    public Coach getCoach(Integer id){
        return coachRepository.findById(id).get();
    }
    public Coach saveCoach(Coach coach){
        return coachRepository.save(coach);
    }
    public void deleteCoach(Integer id){
        if(coachRepository.existsById(id)){
            coachRepository.delete(getCoach(id));
        }
    }
    public Coach updateCoach(Coach coach){
        if(coachRepository.existsById(coach.getId())){
            Coach coach1 = getCoach(coach.getId());
            coachRepository.save(coach);
            return coach1;
        }
        return null;
    }
    public List<Coach> listCoach(){
        return coachRepository.findAll();
    }
}
