package com.vti.frontEnd;

import com.vti.backEnd.controller.UserController;
import com.vti.backEnd.model.Role;
import com.vti.backEnd.model.User;
import com.vti.utils.ScannerUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserFunction {
    private UserController userController = new UserController();
    public static User login(){
//        yêu cầu người dùng nhập vào username, password
//        sd userName, password gọi sang controller -> service -> repository
        User user = new User();

        System.out.println("Mời bạn nhập vào username: ");
        user.setUserName(ScannerUtils.inputString());
        System.out.println("Mời bạn nhập vào password: ");
        user.setPassword(ScannerUtils.inputString());

        user = UserController.login(user.getUserName(), user.getPassword());
        return user; //userName sai hoac password sai
    }

    public static void getAllUsers(){
        List<User> users = new ArrayList<>();
        users = UserController.getAllUsers();
        System.out.println("Danh sách user: ");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "ID", "Role", "Username", "Email", "Date", "DepartmentId", "DepartmentName");
        for (User user : users){
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", user.getId(), user.getRole(), user.getUserName(), user.getEmail(), user.getDate(), user.getDepartmentId(), user.getDepartmentName());
        }
    }

    public static void getUserById(){
        System.out.println("Mời bạn nhập vào id: ");
        int id = ScannerUtils.inputNumber();
        User user = UserController.getUserById(id);
        if(user == null){
            System.out.println("Không tìm thấy user");
        } else {
            System.out.println("Thông tin user: ");
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "ID", "Role", "Username", "Email", "Date", "DepartmentId", "DepartmentName");
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", user.getId(), user.getRole(), user.getUserName(), user.getEmail(), user.getDate(), user.getDepartmentId(), user.getDepartmentName());
        }
    }

    public static void getUserByUserNameAndEmail(){
        System.out.println("Mời bạn nhập vào username hoặc email: ");
        String value = ScannerUtils.inputString();
        User user = UserController.getUserByUserNameAndEmail(value);
        if(user == null){
            System.out.println("Không tìm thấy user");
        } else {
            System.out.println("Thông tin user: ");
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "ID", "Role", "Username", "Email", "Date", "DepartmentId", "DepartmentName");
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", user.getId(), user.getRole(), user.getUserName(), user.getEmail(), user.getDate(), user.getDepartmentId(), user.getDepartmentName());
        }
    }

    public static void deleteUserById(){
        System.out.println("Mời bạn nhập vào id: ");
        int id = ScannerUtils.inputNumber();
        UserController.deleteUserById(id);
    }

    public static void changePassword(){
        System.out.println("Mời bạn nhập vào id: ");
        int id = ScannerUtils.inputNumber();
        System.out.println("Mời bạn nhập vào password mới: ");
        String password = ScannerUtils.inputString();
        UserController.changePassword(id, password);
    }

    public static void addUser(){
        User user = new User();
        System.out.println("Mời bạn nhập vào username: ");
        user.setUserName(ScannerUtils.inputString());
        System.out.println("Mời bạn nhập vào email: ");
        user.setEmail(ScannerUtils.inputString());
        System.out.println("Mời bạn nhập vào ngày sinh: ");
        user.setDate(ScannerUtils.inputDate());
        System.out.println("Mời bạn nhập vào departmentId: ");
        user.setDepartmentId(ScannerUtils.inputNumber());
        user.setRole(Role.USER);
        user.setPassword("123456");
        UserController.addUser(user);
    }
}
