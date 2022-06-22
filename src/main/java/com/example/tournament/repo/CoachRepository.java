package com.example.tournament.repo;

import com.example.tournament.domain.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository <Coach, Integer>{

}
