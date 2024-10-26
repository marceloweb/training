package com.example.game.service;

import com.example.game.model.ScoreCriteria;
import com.example.game.repositoy.ScoreCriteriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreCriteriaService {

    private static final Logger logger = LoggerFactory.getLogger(ScoreCriteriaService.class);

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
        logger.info("Criando novo critério!");

        return scoreCriteriaRepository.save(scoreCriteria);
    }

    public void deleteById(Long id) {
        scoreCriteriaRepository.deleteById(id);
    }

    public void deleteCriteriaById(Long id) {
        scoreCriteriaRepository.deleteById(id);
    }
}
