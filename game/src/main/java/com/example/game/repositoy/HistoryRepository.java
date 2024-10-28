package com.example.game.repositoy;

import com.example.game.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {
    List<History> findByChildId(Long childId);
}
