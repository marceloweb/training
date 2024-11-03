package com.example.game.controller;

import com.example.game.dto.RankingDTO;
import com.example.game.service.RankingService;
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

    @Autowired
    private RankingService rankingService;

    @GetMapping
    public String showRanking(Model model) {
        List<RankingDTO> ranking = rankingService.getRanking();
        model.addAttribute("ranking", ranking);
        return "ranking/show";
    }
}
