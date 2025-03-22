package com.vti.backEnd.service;

import com.vti.backEnd.model.User;

import java.util.List;

public interface UserService {
    User login(String userName, String password);
    List<User> getAllUsers();
    User getUserById(int id);
    User getUserByUserNameAndEmail(String value);
    void deleteUserById(int id);
    void changePassword(int id, String newPassword);
    void addUser(User user);
}
