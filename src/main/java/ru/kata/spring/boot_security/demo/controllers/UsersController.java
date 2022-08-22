package ru.kata.spring.boot_security.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RolesService;
import ru.kata.spring.boot_security.demo.services.UsersService;
import ru.kata.spring.boot_security.demo.services.UsersServiceImpl;


import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@Controller
public class UsersController {

    private final UsersService usersService;

    private final RolesService rolesService;


    @Autowired
    public UsersController(UsersServiceImpl usersService, RolesService rolesService) {

        this.usersService = usersService;
        this.rolesService = rolesService;
    }

    @GetMapping("/admin")
    public String users(@ModelAttribute("user") User user, Model model, Principal principal) {



        model.addAttribute("currentUser", usersService.findByEmail(principal.getName()));

        model.addAttribute("users", usersService.findAll());

        model.addAttribute("user", new User());

        return "admin";
    }


    @PostMapping
    public String addUser(@ModelAttribute("user") @Valid User user,
                          @RequestParam("roleId") List<Integer> roleId) {


        user.setRoles(rolesService.findMultipleById(roleId));

        usersService.save(user);


        return "redirect:/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {

        usersService.delete(id);

        return "redirect:/admin";
    }

    @PatchMapping("/update/{id}")
    public String updateUser(User user,
                             @RequestParam("roleIdToUpdate") List<Integer> roleId) {

        user.setRoles(rolesService.findMultipleById(roleId));

        usersService.update(user);
        return "redirect:/admin";
    }


    @GetMapping("/user")
    public String userPage(Principal principal, Model model) {

        User user = usersService.findByEmail(principal.getName());

        model.addAttribute("currentUser", user);

        System.out.println(user);

        return "user";
    }
}

