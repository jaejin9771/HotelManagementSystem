/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.projects.hms.controller;

import cse.projects.hms.dao.user.UserDao;
import cse.projects.hms.dto.user.UserDto;
import cse.projects.hms.dto.user.UserLoginDto;
import java.io.BufferedReader;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 재진
 */
public class UserController {

    public static UserController userController = new UserController();
    private String userType;
    public static UserController getInstance() {
        return userController;
    }
    private static UserDao userDao;

    public UserController() {
        userDao = new UserDao();
    }
    
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public UserDto login(String inputId, String inputPw) {
        UserLoginDto dto = new UserLoginDto(inputId, inputPw);

        UserDto user = userDao.findByIdAndPw(dto);

        return user;
    }

    public boolean signUp(String inputId, String inputPw, String usertype) {
        UserDto dto = new UserDto(inputId, inputPw, usertype);
        
        if(userDao.insert(dto)){
            return true;
        } else {
            return false;
        }
    }
}
