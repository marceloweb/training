package com.example.game.controller;

import com.example.game.model.PenaltyCriteria;
import com.example.game.service.PenaltyCriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/penalty-criteria")
public class PenaltyCriteriaController {

    @Autowired
    private PenaltyCriteriaService penaltyCriteriaService;

    @GetMapping("/list")
    public String listPenaltyCriteria(Model model) {
        List<PenaltyCriteria> penalties = penaltyCriteriaService.findAll();
        model.addAttribute("penalties", penalties);
        return "penalty-criteria-list";
    }

    @GetMapping("/add")
    public String showAddPenaltyCriteriaForm(Model model) {
        model.addAttribute("penaltyCriteria", new PenaltyCriteria());
        return "add-penalty-criteria-form";
    }

    @PostMapping("/add")
    public String addPenaltyCriteria(@ModelAttribute PenaltyCriteria penaltyCriteria) {
        penaltyCriteriaService.save(penaltyCriteria);
        return "redirect:/penalty-criteria/list";
    }
}
