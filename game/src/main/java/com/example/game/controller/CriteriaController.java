package com.example.game.controller;

import com.example.game.model.PenaltyCriteria;
import com.example.game.model.ScoreCriteria;
import com.example.game.model.User;
import com.example.game.service.PenaltyCriteriaService;
import com.example.game.service.ScoreCriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CriteriaController {

    @Autowired
    ScoreCriteriaService scoreCriteriaService;

    @Autowired
    PenaltyCriteriaService penaltyCriteriaService;

    @GetMapping("/criterios")
    public String listarTios(Model model) {
        List<ScoreCriteria> scoreCriteria = scoreCriteriaService.findAll();
        model.addAttribute("criterias", scoreCriteria);

        return "criteria/criteria";
    }

    @GetMapping("/criterios/adicionar")
    public String showScoreCriteriaForm(Model model) {
        model.addAttribute("criterios", new ScoreCriteria());
        return "criteria/criteria-register";
    }

    @PostMapping("/criterios/adicionar")
    public String saveScoreCriteria(@ModelAttribute ScoreCriteria scoreCriteria) {
        scoreCriteriaService.save(scoreCriteria);
        return "redirect:/criterios";
    }

    @GetMapping("/penalidade/adicionar")
    public String showPenaltyCriteriaForm(Model model) {
        model.addAttribute("penaltyCriteria", new PenaltyCriteria());
        return "criteria/penalty-register";
    }

    @PostMapping("/penalidade/adicionar")
    public String savePenaltyCriteria(@ModelAttribute PenaltyCriteria penaltyCriteria) {
        penaltyCriteriaService.save(penaltyCriteria);
        return "redirect:/criteria/penalty";
    }

    @GetMapping("/criterios/alterar/{id}")
    public String exibirFormularioAtualizacao(@PathVariable Long id, Model model) {
        ScoreCriteria scoreCriteria = scoreCriteriaService.findById(id);
        model.addAttribute("criteria", scoreCriteria);
        return "criteria/edit";
    }

    @PostMapping("/criterios/alterar/{id}")
    public String update(@ModelAttribute ScoreCriteria scoreCriteria) {
        scoreCriteriaService.save(scoreCriteria);
        return "redirect:/criterios";
    }

    @PostMapping("/criterios/excluir/{id}")
    public String deleteScoreCriteria(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            scoreCriteriaService.deleteCriteriaById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Critério excluído com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao excluir o critério.");
        }
        return "redirect:/criterios";
    }
}
