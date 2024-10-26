package com.example.game.controller;

import com.example.game.model.PenaltyCriteria;
import com.example.game.model.ScoreCriteria;
import com.example.game.service.PenaltyCriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PenaltyCriteriaController {

    @Autowired
    PenaltyCriteriaService penaltyCriteriaService;

    @GetMapping("/penalidades")
    public String listPenaltyCriteria(Model model) {
        List<PenaltyCriteria> penalties = penaltyCriteriaService.findAll();
        model.addAttribute("penalties", penalties);
        return "penalty-criteria/penalty-criteria-list";
    }

    @GetMapping("/penalidades/adicionar")
    public String showAddPenaltyCriteriaForm(Model model) {
        model.addAttribute("penalties", new PenaltyCriteria());
        return "penalty-criteria/add-penalty-criteria-form";
    }

    @PostMapping("/penalidades/adicionar")
    public String addPenaltyCriteria(@ModelAttribute PenaltyCriteria penaltyCriteria) {
        penaltyCriteriaService.save(penaltyCriteria);
        return "redirect:/penalidades";
    }

    @GetMapping("/penalidades/alterar/{id}")
    public String exibirFormularioAtualizacao(@PathVariable Long id, Model model) {
        PenaltyCriteria penaltyCriteria = penaltyCriteriaService.findById(id);
        model.addAttribute("penalty", penaltyCriteria);
        return "penalty-criteria/edit";
    }

    @PostMapping("/penalidades/alterar/{id}")
    public String update(@ModelAttribute PenaltyCriteria penaltyCriteria) {
        penaltyCriteriaService.save(penaltyCriteria);
        return "redirect:/penalidades";
    }

    @PostMapping("/penalidades/excluir/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            penaltyCriteriaService.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Critério excluído com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao excluir o critério.");
        }
        return "redirect:/penalidades";
    }
}
