package com.example.game.controller;

import com.example.game.model.PenaltyCriteria;
import com.example.game.model.ScoreCriteria;
import com.example.game.service.PenaltyCriteriaService;
import com.example.game.service.ScoreCriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/criteria")
public class CriteriaController {

    @Autowired
    ScoreCriteriaService scoreCriteriaService;

    @Autowired
    PenaltyCriteriaService penaltyCriteriaService;

    @GetMapping("/score")
    public String showScoreCriteriaForm(Model model) {
        model.addAttribute("scoreCriteria", new ScoreCriteria());
        return "criteria/criteria-register";
    }

    @PostMapping("/score")
    public String saveScoreCriteria(@ModelAttribute ScoreCriteria scoreCriteria) {
        scoreCriteriaService.save(scoreCriteria);
        return "redirect:/criteria/score";
    }

    @GetMapping("/penalty")
    public String showPenaltyCriteriaForm(Model model) {
        model.addAttribute("penaltyCriteria", new PenaltyCriteria());
        return "criteria/penalty-register";
    }

    @PostMapping("/penalty")
    public String savePenaltyCriteria(@ModelAttribute PenaltyCriteria penaltyCriteria) {
        penaltyCriteriaService.save(penaltyCriteria);
        return "redirect:/criteria/penalty";
    }
}
