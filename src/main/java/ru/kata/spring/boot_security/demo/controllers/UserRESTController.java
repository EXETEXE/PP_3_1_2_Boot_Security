package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UsersService;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class UserRESTController {

    private final UsersService usersService;

    @Autowired
    public UserRESTController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public String userPage(Principal principal) {

        User user = usersService.findByEmail(principal.getName());


        System.out.println(user);

        return "user";
    }
}
