package org.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Users Club");
        return "home";
    }
}
