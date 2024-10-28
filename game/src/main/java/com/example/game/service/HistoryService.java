package com.example.game.service;

import com.example.game.model.History;
import com.example.game.repositoy.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    public void addHistory(Long childId, Long userId, String action, int points) {
        History history = new History();
        history.setChildId(childId);
        history.setUserId(userId);
        history.setAction(action);
        history.setPoints(points);
        history.setDate(LocalDate.now());
        historyRepository.save(history);
    }

    public List<History> getHistoryByChildId(Long childId) {
        return historyRepository.findByChildId(childId);
    }
}
