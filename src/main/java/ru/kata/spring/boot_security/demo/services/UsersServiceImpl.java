package ru.kata.spring.boot_security.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.dao.RoleDAO;
import ru.kata.spring.boot_security.demo.dao.UserDAO;
import ru.kata.spring.boot_security.demo.dto.UserDTO;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;


@Component
public class UsersServiceImpl implements UsersService {


    UserDAO userDAO;
    RoleDAO roleDAO;

    public UsersServiceImpl() {
    }

    @Autowired
    public UsersServiceImpl(UserDAO userDAO, RoleDAO roleDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }

    @Override
    public List<User> findAll() {

        return userDAO.findAll();
    }

    @Override
    public User findOne(Long id) {

        return userDAO.findOne(id);
    }

    @Override
    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    @Override
    public void save(User user) {

        userDAO.save(user);
    }

    @Override
    public void save(UserDTO userDTO) {

        User user = userDTO.getUser();

        user.setRoles(roleDAO.findMultipleById(userDTO.getRolesId()));

        userDAO.save(user);
    }

    @Override
    public void delete(Long id) {

        userDAO.delete(id);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void update(UserDTO userDTO) {

        User user = userDTO.getUser();

        user.setRoles(roleDAO.findMultipleById(userDTO.getRolesId()));

        userDAO.update(user);
    }
}
