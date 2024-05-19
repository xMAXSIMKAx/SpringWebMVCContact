package org.example.app.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.app.entity.User;
import org.example.app.service.impl.member.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public String fetchAllUsers(Model model) {
        List<User> list = userService.fetchAll();
        model.addAttribute("title", "Users");
        model.addAttribute("users", list);
        return "user_list";
    }

    @RequestMapping("/create-user")
    public String createUser(Model model) {
        model.addAttribute("title", "Add User");
        return "user_add";
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public RedirectView addUser(@ModelAttribute User user, HttpServletRequest request) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/users");
        if (userService.create(user))
            return redirectView;
        else return redirectView;
    }

    @RequestMapping("/update-user/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("title", "Update User");
        User user = userService.fetchById(id);
        model.addAttribute("user", user);
        return "user_update";
    }

    @RequestMapping(value = "/change-user", method = RequestMethod.POST)
    public RedirectView changeUser(@ModelAttribute User user, HttpServletRequest request) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/users");
        if (userService.update(user.getId(), user))
            return redirectView;
        else return redirectView;
    }

    @RequestMapping("/delete-user/{id}")
    public RedirectView deleteUser(@PathVariable("id") Long id,
                                   HttpServletRequest request) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/users");
        if (userService.delete(id)) return redirectView;
        else return redirectView;
    }
}
