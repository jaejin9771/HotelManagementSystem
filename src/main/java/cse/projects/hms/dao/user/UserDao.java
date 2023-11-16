/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.projects.hms.dao.user;

import cse.projects.hms.dto.user.*;
import cse.projects.hms.dto.user.UserDto.UserBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 재진
 */
public class UserDao {

    public UserDto findByIdAndPw(UserLoginDto loginDto) {
        UserDto userDto = new UserDto();

        String fileName = "data/user.txt";
        File file = new File(fileName);

        try {
            
            BufferedReader br = new BufferedReader(new FileReader(file));
                    
            String line;
            while ((line = br.readLine()) != null) {                
                String[] userInfo = line.split(","); // txt파일에 저장되어있는 아이디와 비밀번호를 나눠서 저장.
                 

                System.out.println("cse.projects.hms.dao.user.UserDao.findByIdAndPw() : 입력한 값 : "+loginDto.getId()+","+loginDto.getPw());                
                System.out.println("cse.projects.hms.dao.user.UserDao.findByIdAndPw() : 비교할 값 : "+userInfo[0]+","+userInfo[1]);
                // id pw 확인
                if (loginDto.getId().equals(userInfo[0])) {
                    if (loginDto.getPw().equals(userInfo[1])) {
                                              
                        userDto = new UserBuilder()
                                .id(loginDto.getId())
                                .pw(loginDto.getPw())
                                .usertype(userInfo[2])
                                .build();
                        return userDto;
                      
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        //없다면
        return null;
    }

    public boolean findById(String id) {
        String fileName = "data/user.txt";
        File file = new File(fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userInfo = line.split(","); // txt파일에 저장되어있는 아이디와 비밀번호를 나눠서 저장.
                if (id.equals(userInfo[0])) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
