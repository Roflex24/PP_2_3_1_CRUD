package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/")
    public String showAll(Model model) {
        List<User> getAllUsers = userService.getAllUsers();
        model.addAttribute("allUsers", getAllUsers);
        return "index";
    }

    @RequestMapping(value = "/add")
    public String addNewUser(Model model) {
        model.addAttribute("newUser", new User());
        return "add";
    }

    @RequestMapping(value = "/save")
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit")
    public String editUser(@RequestParam int id, Model model) {
        model.addAttribute("editUser", userService.getUser(id));
        return "update";
    }

    @RequestMapping(value = "/update")
    public String updateUser(@ModelAttribute("editUser") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete")
    public String deleteUser(@RequestParam int id) {
        userService.removeUser(id);
        return "redirect:/";
    }
}
