package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.Role;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public interface RolesService {

    public List<Role> findAll();

    public Role findOne(Integer id);

    public HashSet<Role> findMultipleById(Collection<Integer> idCollection);

    public void save(Role role);

    public void delete(Integer id);

    void update(Role role);
}
