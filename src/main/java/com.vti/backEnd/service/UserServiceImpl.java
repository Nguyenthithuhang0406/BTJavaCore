package com.vti.backEnd.service;

import com.vti.backEnd.model.User;
import com.vti.backEnd.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService{
    private UserRepository repository = new UserRepository();
    @Override
    public User login(String userName, String password) {
        return repository.login(userName, password);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return repository.getUserById(id);
    }

    @Override
    public User getUserByUserNameAndEmail(String value) {
        return repository.getUserByUserNameAndEmail(value);
    }

    @Override
    public void deleteUserById(int id) {
        repository.deleteUserById(id);
    }

    @Override
    public void changePassword(int id, String newPassword) {
        repository.changePassword(id, newPassword);
    }

    @Override
    public void addUser(User user) {
        repository.addUser(user);
    }
}
