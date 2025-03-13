package com.gradlespring.gradlespring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam("username") String username, @RequestParam("age") String age, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("age", age);
        return "greetings";
    }
}