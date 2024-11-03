package com.example.game.service;

import com.example.game.dto.RankingDTO;
import com.example.game.repositoy.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RankingService {

    @Autowired
    private HistoryRepository historyRepository;


    public List<RankingDTO> getRanking() {
        List<Object[]> results = historyRepository.findRanking();
        List<RankingDTO> ranking = new ArrayList<>();

        for (Object[] result : results) {
            RankingDTO dto = new RankingDTO();
            dto.setChildId((Long) result[0]);
            dto.setNickname((String) result[1]);
            dto.setTeam((String) result[2]);
            dto.setTotalPoints((Long) result[3]);
            ranking.add(dto);
        }

        return ranking;
    }
}
