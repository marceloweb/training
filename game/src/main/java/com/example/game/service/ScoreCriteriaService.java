package com.example.game.service;

import com.example.game.model.ScoreCriteria;
import com.example.game.repositoy.ScoreCriteriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreCriteriaService {

    @Autowired
    private ScoreCriteriaRepository scoreCriteriaRepository;

    public List<ScoreCriteria> findAll() {
        return scoreCriteriaRepository.findAll();
    }

    public ScoreCriteria findById(Long id) {
        return scoreCriteriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Score criteria not found"));
    }

    public ScoreCriteria save(ScoreCriteria scoreCriteria) {
        return scoreCriteriaRepository.save(scoreCriteria);
    }

    public void deleteById(Long id) {
        scoreCriteriaRepository.deleteById(id);
    }
}
