package com.example.game.controller;

import com.example.game.model.User;
import com.example.game.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/equipe")
    public String listarTios(Model model) {

        List<User> users = userService.getAllUsers();

        model.addAttribute("users", users);

        return "users/users";
    }
}
