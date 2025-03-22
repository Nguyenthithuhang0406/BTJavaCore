package com.vti.frontEnd;

import com.vti.backEnd.model.Role;
import com.vti.backEnd.model.User;
import com.vti.utils.ScannerUtils;

public class Program {
    public static void main(String[] args) {
        User user = null;
        while (user == null){
            user = UserFunction.login();
            if(user == null){
                System.out.println("Sai thông tin đăng nhập, mời bạn nhập lại");
            }
        }
        int choose;
//        điều hướng menu
        if(Role.ADMIN == user.getRole()){
            do {
                menuAdmin();
                System.out.println("Mời bạn nhập lựa chọn: ");
                choose = ScannerUtils.inputNumber(1, 9);
                switch (choose){
                    case 1:
                        UserFunction.getAllUsers();
                        break;
                    case 2:
                        UserFunction.deleteUserById();
                        break;
                    case 3:
                        UserFunction.changePassword();
                        break;
                    case 4:
                        UserFunction.addUser();
                        break;
                    case 5:
                        DepartmentFunction.getAllDepartments();
                        break;
                    case 6:
                        DepartmentFunction.deleteDepartmentById();
                        break;
                    case 7:
                        DepartmentFunction.changeDepartmentName();
                        break;
                    case 8:
                        DepartmentFunction.addDepartment();
                        break;
                    case 9:
                        ScannerUtils.close();
                        break;
                    default:
                        System.out.println("Nhập sai, mời bạn nhập lại");
                        break;
                }
            }while (choose != 9);
        } else {
            do{
                menuUser();
                System.out.println("Mời bạn nhập lựa chọn: ");
                choose = ScannerUtils.inputNumber(1, 7);
                switch (choose){
                    case 1:
                        UserFunction.getAllUsers();
                        break;
                    case 2:
                       UserFunction.getUserById();
                        break;
                    case 3:
                        UserFunction.getUserByUserNameAndEmail();
                        break;
                    case 4:
                        DepartmentFunction.getAllDepartments();
                        break;
                    case 5:
                        DepartmentFunction.getDepartmentById();
                        break;
                    case 6:
                        DepartmentFunction.findDepartmentByName();
                        break;
                    case 7:
                        ScannerUtils.close();
                        break;
                    default:
                        System.out.println("Nhập sai, mời bạn nhập lại");
                        break;
                }
            } while (choose != 7);
        }
    }

    public static void menuAdmin(){
        System.out.println("============Menu User===============");
        System.out.println("1. Hiển thị danh sách user");
        System.out.println("2. Xoá User theo id");
        System.out.println("3. Thay đổi mật khẩu của 1 user");
        System.out.println("4. Thêm mới 1 User");
        System.out.println("5. Hiển thị danh sách Department");
        System.out.println("6. Xoá 1 Department theo id");
        System.out.println("7. Thay đổi tên 1 Department");
        System.out.println("8. Thêm mới 1 Department");
        System.out.println("9. Đóng chương trình");
    }

    public static void menuUser(){
        System.out.println("============Menu Admin===============");
        System.out.println("1. Hiển thị danh sách user");
        System.out.println("2. Tìm kiếm user theo id");
        System.out.println("3. Tìm kiếm user theo username và email");
        System.out.println("4. Hiển thị danh sach department");
        System.out.println("5. Tìm kiếm department theo id");
        System.out.println("6. Tìm kiếm department theo departmentName");
        System.out.println("7. Đóng chương trình");
    }
}
