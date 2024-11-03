package com.example.game.service;

import com.example.game.dto.RankingDTO;
import com.example.game.model.Child;
import com.example.game.model.History;
import com.example.game.repositoy.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    public void addHistory(Child childId, Long userId, String action, int points) {
        History history = new History();
        history.setChild(childId);
        history.setUserId(userId);
        history.setAction(action);
        history.setPoints(points);
        history.setDate(LocalDate.now());
        historyRepository.save(history);
    }

    public List<History> getHistoryByChildId(Child childId) {
        return historyRepository.findByChildId(childId);
    }
}
