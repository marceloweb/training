package com.example.game.repositoy;

import com.example.game.model.Child;
import com.example.game.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Child> {
    List<History> findByChildId(Child childId);

    @Query("SELECT DISTINCT h.child.id, c.nickname, t.name AS team, SUM(h.points) AS totalPoints " +
            "FROM History h JOIN h.child c JOIN team t GROUP BY h.child.id, h.nickname, t.name ORDER BY totalPoints DESC")
    List<Object[]> findRanking();
}
