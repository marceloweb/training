package com.example.game.controller;

import com.example.game.model.Child;
import com.example.game.model.Team;
import com.example.game.service.ChildService;
import com.example.game.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ranking")
public class RankingController {

    @Autowired
    ChildService childService;

    @Autowired
    TeamService teamService;

    @GetMapping
    public String showRanking(Model model) {
        List<Child> children = childService.findAllOrderByScore();
        List<Team> teams = teamService.findAllOrderByScore();
        model.addAttribute("childrenRanking", children);
        model.addAttribute("teamRanking", teams);
        return "ranking";
    }
}
