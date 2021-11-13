package springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.model.Role;
import springboot.model.User;
import springboot.service.RoleService;
import springboot.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String showAll(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "admin/users";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/user";
    }

    @GetMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        return "admin/new";
    }

    @PostMapping("/")
    public String create(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/admin/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("roles", roleService.getRoles());
        model.addAttribute("user", userService.getUserById(id));
        return "admin/edit";
    }

    @PostMapping("/{id}")
    public String updateUser(
            @ModelAttribute("user") User user,
            @RequestParam("roles") long[] roleId
    ) {
        Set<Role> roleSet = new HashSet<>();
        for (long id : roleId) {
            Role role = roleService.getRoleById(id);
            roleSet.add(role);
        }
        user.setRoles(roleSet);
        if (userService.isPasswordChanged(userService.getUserById(user.getId()).getPassword(), user.getPassword())) {
            userService.createUser(user);
        } else {
            userService.updateUser(user);
        }
        return "redirect:/admin/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin/";
    }
}
