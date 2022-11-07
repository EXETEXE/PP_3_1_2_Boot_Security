package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.dto.UserDTO;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RolesService;
import ru.kata.spring.boot_security.demo.services.UsersService;
import ru.kata.spring.boot_security.demo.services.UsersServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminPageRESTController {

    private final UsersService usersService;


    @Autowired
    public AdminPageRESTController(UsersServiceImpl usersService) {

        this.usersService = usersService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {

        return usersService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {

        return usersService.findOne(id);
    }

    @PostMapping
    public void addUser(@RequestBody UserDTO userDTO) {

        System.out.println(userDTO.getUser());
        System.out.println();

        usersService.save(userDTO);
    }

    @PatchMapping
    public void updateUser(@RequestBody UserDTO userDTO) {

        System.out.println(userDTO.getUser());

        usersService.update(userDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable long id) {

        usersService.delete(id);
    }



}
