package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDAO {

    public List<User> findAll();

    public User findOne(Long id);

    public User findByEmail(String email);

    public void save(User user);

    public void delete(Long id);

    void update(User user);
}
