package com.example.game.repositoy;

import com.example.game.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child, Long> {

    List<Child> findAllByOrderByTotalScoreDesc();
}
