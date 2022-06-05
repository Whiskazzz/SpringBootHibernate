package com.daniil.springboothibernate.web.contollers;

import com.daniil.springboothibernate.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping
    public String addUser(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("email") String email) {
        userService.addUser(name, surname, email);
        return "redirect:/users";
    }

    @PatchMapping
    public String changeUser(@RequestParam("id") long id, @RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("email") String email) {
        userService.updateUser(id,name,surname,email);
        return "redirect:/users";
    }

    @DeleteMapping
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }


}
