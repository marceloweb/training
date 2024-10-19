package com.example.game.service;

import com.example.game.model.Team;
import com.example.game.repositoy.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    // Método para retornar todos os times, ordenados pela pontuação total de forma decrescente
    public List<Team> findAllOrderByScore() {
        return teamRepository.findAllByOrderByTotalScoreDesc();
    }
}
