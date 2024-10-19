package com.example.game.service;

import com.example.game.model.Child;
import com.example.game.repositoy.ChildRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildService {

    @Autowired
    private ChildRepository childRepository;

    public List<Child> findAll() {
        return childRepository.findAll();
    }

    public Child findById(Long id) {
        return childRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Child not found"));
    }

    public Child save(Child child) {
        return childRepository.save(child);
    }

    public void deleteById(Long id) {
        childRepository.deleteById(id);
    }

    // Você pode adicionar métodos adicionais para lógica de negócio, como:
    public List<Child> findAllOrderByScore() {
        return childRepository.findAllByOrderByTotalScoreDesc();
    }
}
