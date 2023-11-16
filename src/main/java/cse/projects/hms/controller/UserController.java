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
    public static UserController getInstance(){ return userController; }
    private static UserDao userDao;
    public UserController() {
        userDao = new UserDao();
    }

    public UserDto login(String inputId, String inputPw) {
        UserLoginDto dto = new UserLoginDto(inputId,inputPw);
        
        UserDto user = userDao.findByIdAndPw(dto);
        
        return user;
    }
    
    public boolean isRegister(String inputId, String inputPw) {
        File file = new File("data/user.txt");
        String split = ",";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))) {
            bw.newLine();
            bw.write(inputId);
            bw.write(split);
            bw.write(inputPw);
            
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
//    public int findByIdAndPw(String inputId){
//        File file = new File("user.txt");
//        int check = 0;
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] userInfo = line.split(","); // txt파일에 저장되어있는 아이디와 비밀번호를 나눠서 저장.
//                String storedId = userInfo[0]; // txt파일에 있는 ID
//                
//                if(inputId.equals(storedId)){
//                    check = 1;
//                   return check; 
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("아이디 찾기 오류");
//        }
//        return check;
//    }
}
