package ru.kata.spring.boot_security.demo.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UsersService;
import ru.kata.spring.boot_security.demo.services.UsersServiceImpl;

import java.security.Principal;


@Controller
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersServiceImpl usersService) {

        this.usersService = usersService;

    }

    @GetMapping("/admin")
    public String users() {

        return "admin";
    }

    @GetMapping("/test")
    public String test() {

        return "test";
    }

    @GetMapping("/authenticated")
    @ResponseBody
    public ResponseEntity<User> authenticated(Principal principal) {
        return ResponseEntity.ok().body(usersService.findByEmail(principal.getName()));
    }

}

