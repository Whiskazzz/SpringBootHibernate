package com.daniil.springboothibernate.web.service;

import com.daniil.springboothibernate.web.model.User;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();

    void addUser(String name, String lastName, String email);
    void deleteUser(Long id);
    void updateUser(long id, String name, String lastName, String email);

}
