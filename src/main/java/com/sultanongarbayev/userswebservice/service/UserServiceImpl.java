package com.sultanongarbayev.userswebservice.service;

import com.sultanongarbayev.userswebservice.dao.UserDAO;
import com.sultanongarbayev.userswebservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    @Override
    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public boolean deleteUser(int userId) {
        return userDAO.deleteUser(userId);
    }
}
