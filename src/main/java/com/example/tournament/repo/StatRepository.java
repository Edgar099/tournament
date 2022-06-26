package com.example.tournament.repo;

import com.example.tournament.domain.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatRepository extends JpaRepository<Stat, Integer> {
}
