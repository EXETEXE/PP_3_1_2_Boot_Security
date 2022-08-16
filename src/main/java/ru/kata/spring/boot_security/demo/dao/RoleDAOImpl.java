package ru.kata.spring.boot_security.demo.dao;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Component
@Transactional
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> findAll() {

        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role findOne(Integer id) {

        return entityManager.find(Role.class, id);
    }

    @Override
    public HashSet<Role> findMultipleById(Collection<Integer> idCollection) {

        HashSet<Role> result = new HashSet<>();

        for (Integer id : idCollection) {

            result.add(findOne(id));
        }

        return result;
    }

    @Override
    public void save(Role role) {

        entityManager.persist(role);
    }

    @Override
    public void delete(Integer id) {

        entityManager.remove(entityManager.find(Role.class, id));
    }

    @Override
    public void update(Role role) {

        entityManager.merge(role);
    }


}
