package com.vti.backEnd.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class User {
    private Integer id;
    private String name;
    private Role role;
    private String userName;
    private String password;
    private String email;
    private Date date;
    private Integer departmentId;
    private String departmentName;
}
