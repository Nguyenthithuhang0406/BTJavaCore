package com.vti.backEnd.controller;

import com.vti.backEnd.model.User;
import com.vti.backEnd.service.UserService;
import com.vti.backEnd.service.UserServiceImpl;

import java.util.List;

public class UserController {
    private static UserService repository = new UserServiceImpl();

    public static User login(String userName, String password) {
        //kiểm tra xem userName, password có rỗng không (controller)
        // kiểm tra xem có tồn tại khum (service)
        return repository.login(userName, password);
    }

    public static List<User> getAllUsers() {
        return repository.getAllUsers();
    }

    public static User getUserById(int id) {
        return repository.getUserById(id);
    }

    public static User getUserByUserNameAndEmail(String value) {
        return repository.getUserByUserNameAndEmail(value);
    }

    public static void deleteUserById(int id) {
        repository.deleteUserById(id);
    }

    public static void changePassword(int id, String newPassword) {
        repository.changePassword(id, newPassword);
    }

    public static void addUser(User user) {
        repository.addUser(user);
    }
}
