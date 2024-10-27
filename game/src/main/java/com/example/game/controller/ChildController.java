package com.example.game.controller;

import com.example.game.model.Child;
import com.example.game.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("child", new Child());
        return "children/add-child-form";
    }

    @PostMapping("/sub13/adicionar")
    public String addChild(@ModelAttribute Child child) {
        childService.save(child);
        return "redirect:/sub13";
    }
}
