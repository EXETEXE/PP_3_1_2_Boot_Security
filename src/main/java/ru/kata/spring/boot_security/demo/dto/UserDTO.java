package ru.kata.spring.boot_security.demo.dto;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public class UserDTO {

    private User user;
    private List<Integer> rolesId;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getRolesId() {
        return rolesId;
    }

    public void setRolesId(List<Integer> rolesId) {
        this.rolesId = rolesId;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "user=" + user +
                ", rolesId=" + rolesId +
                '}';
    }
}
