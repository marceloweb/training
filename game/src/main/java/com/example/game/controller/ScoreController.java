package com.example.game.controller;

import com.example.game.model.Child;
import com.example.game.model.PenaltyCriteria;
import com.example.game.model.ScoreCriteria;
import com.example.game.service.ChildService;
import com.example.game.service.PenaltyCriteriaService;
import com.example.game.service.ScoreCriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private ChildService childService;

    @Autowired
    private ScoreCriteriaService scoreCriteriaService;

    @Autowired
    private PenaltyCriteriaService penaltyCriteriaService;

    @GetMapping("/assign")
    public String showAssignPointsForm(Model model) {
        model.addAttribute("children", childService.findAll());
        model.addAttribute("criteria", scoreCriteriaService.findAll());
        return "assignPointsForm";
    }

    @PostMapping("/assign")
    public String assignPoints(@RequestParam Long childId, @RequestParam Long criteriaId) {
        Child child = childService.findById(childId);
        ScoreCriteria criteria = scoreCriteriaService.findById(criteriaId);
        child.setTotalScore(child.getTotalScore() + criteria.getPoints());
        childService.save(child);
        return "redirect:/ranking";
    }

    @GetMapping("/penalize")
    public String showPenalizePointsForm(Model model) {
        model.addAttribute("children", childService.findAll());
        model.addAttribute("penalties", penaltyCriteriaService.findAll());
        return "penalizePointsForm";
    }

    @PostMapping("/penalize")
    public String penalizePoints(@RequestParam Long childId, @RequestParam Long penaltyId) {
        Child child = childService.findById(childId);
        PenaltyCriteria penalty = penaltyCriteriaService.findById(penaltyId);
        child.setTotalScore(child.getTotalScore() - penalty.getPointsToDeduct());
        childService.save(child);
        return "redirect:/ranking";
    }
}
