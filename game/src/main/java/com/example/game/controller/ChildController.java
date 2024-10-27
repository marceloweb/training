package com.example.game.controller;

import com.example.game.model.Child;
import com.example.game.model.PenaltyCriteria;
import com.example.game.model.Team;
import com.example.game.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class ChildController {

    @Autowired
    private ChildService childService;

    @GetMapping("/sub13")
    public String listChildren(Model model) {
        List<Child> children = childService.findAll();
        model.addAttribute("children", children);
        return "children/child-list";
    }

    @GetMapping("/sub13/adicionar")
    public String showAddChildForm(Model model) {
        model.addAttribute("sub13", new Child());
        return "children/add-child-form";
    }

    @PostMapping("/sub13/adicionar")
    public String addChild(@ModelAttribute Child child) {
        childService.save(child);
        return "redirect:/sub13";
    }

    @GetMapping("/sub13/alterar/{id}")
    public String exibirFormularioAtualizacao(@PathVariable Long id, Model model) {
        Child child = childService.findById(id);

        model.addAttribute("sub13", child);
        return "children/edit";
    }

    @PostMapping("/sub13/alterar/{id}")
    public String update(@ModelAttribute Child child) {
        childService.save(child);
        return "redirect:/sub13";
    }

    @PostMapping("/sub13/excluir/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            childService.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Sub13 excluído com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao excluir sub13.");
        }
        return "redirect:/sub13";
    }
}
