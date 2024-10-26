package com.example.game.controller;

import com.example.game.model.User;
import com.example.game.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/cadastro")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/cadastro")
    public String registerUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/equipe";
    }

    @GetMapping("/equipe/alterar/{id}")
    public String exibirFormularioAtualizacao(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/equipe/{id}")
    public String atualizarTio(@PathVariable Long id, @ModelAttribute("user") User userAtualizado, RedirectAttributes redirectAttributes) {
        try {
            userService.updateUser(id, userAtualizado);
            redirectAttributes.addFlashAttribute("successMessage", "Tio atualizado com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao atualizar o tio.");
        }
        return "redirect:/equipe";
    }

    @PostMapping("/equipe/alterar")
    public String updateUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/equipe";
    }

    @PostMapping("/excluir/{id}")
    public String deleteUser(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            userService.deleteUserById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Usuário excluído com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao excluir o usuário.");
        }
        return "redirect:/equipe";
    }
}
