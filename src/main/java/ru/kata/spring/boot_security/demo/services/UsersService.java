package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.dto.UserDTO;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UsersService {

    public List<User> findAll();

    public User findOne(Long id);

    public User findByEmail(String email);

    public void save(User user);

    public void save(UserDTO userDTO);

    public void delete(Long id);

    void update(User user);

    void update(UserDTO userDTO);
}

