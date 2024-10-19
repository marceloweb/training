package com.example.game.service;

import com.example.game.model.PenaltyCriteria;
import com.example.game.repositoy.PenaltyCriteriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenaltyCriteriaService {

    @Autowired
    private PenaltyCriteriaRepository penaltyCriteriaRepository;

    public List<PenaltyCriteria> findAll() {
        return penaltyCriteriaRepository.findAll();
    }

    public PenaltyCriteria findById(Long id) {
        return penaltyCriteriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Penalty criteria not found"));
    }

    public PenaltyCriteria save(PenaltyCriteria penaltyCriteria) {
        return penaltyCriteriaRepository.save(penaltyCriteria);
    }

    public void deleteById(Long id) {
        penaltyCriteriaRepository.deleteById(id);
    }
}
