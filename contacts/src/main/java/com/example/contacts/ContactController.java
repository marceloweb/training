package com.example.contacts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
;

@Controller
@RequestMapping("/")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contacts")
    public String listComtacts(Model model, @RequestParam(value = "search", required = false) String search) {
        if (search != null) {
            model.addAttribute("contacts", contactService.searchContacts(search));
        } else {
            model.addAttribute("contacts", contactService.getAllContacts());
        }
        return "contacts";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "form";
    }

    @PostMapping
    public String saveContact(@ModelAttribute Contact contact) {
        contactService.saveContact(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/edit/{id}")
    public String editContact(@PathVariable Long id, Model model) {
        model.addAttribute("contact", contactService.getContactById(id));
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return "redirect:/contacts";
    }

}
