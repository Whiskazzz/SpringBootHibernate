package com.daniil.springboothibernate.web.service;

import com.daniil.springboothibernate.web.dao.UserDao;
import com.daniil.springboothibernate.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(String name, String lastName, String email) {
        userDao.saveUser(name,lastName,email);

    }

    @Override
    public void deleteUser(Long id) {
        userDao.removeUserById(id);
    }

    @Override
    public void updateUser(long id, String name, String lastName, String email) {
        userDao.changeUserById(id, name, lastName, email);
    }
}
