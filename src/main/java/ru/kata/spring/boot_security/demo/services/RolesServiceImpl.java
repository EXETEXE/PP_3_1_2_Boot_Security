package ru.kata.spring.boot_security.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.dao.RoleDAO;
import ru.kata.spring.boot_security.demo.models.Role;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Component
public class RolesServiceImpl implements RolesService {

    RoleDAO roleDAO;

    public RolesServiceImpl() {
    }

    @Autowired
    public RolesServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> findAll() {

        return roleDAO.findAll();
    }

    @Override
    public Role findOne(Integer id) {

        return roleDAO.findOne(id);
    }

    @Override
    public HashSet<Role> findMultipleById(Collection<Integer> idCollection) {

        return roleDAO.findMultipleById(idCollection);
    }

    @Override
    public void save(Role role) {

        roleDAO.save(role);
    }

    @Override
    public void delete(Integer id) {

        roleDAO.delete(id);
    }

    @Override
    public void update(Role role) {

        roleDAO.update(role);
    }
}
