/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.projects.hms.controller;

import cse.projects.hms.dao.reservation.ResDao;
import java.io.*;
import javax.swing.JButton;

/**
 *
 * @author ij944
 */
public class RoomController {
    public boolean isEmptyRoom(String e) { //e가 방 번호 string
        ResDao res = new ResDao();
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            
            String line;
            
            while((line = br.readLine()) != null){//줄단위로 읽기
                String[] userInfo = line.split(",");
                if(e.equals(userInfo[3])){
                    return false;
                }
           }
            
        }catch(IOException ex){
            ex.printStackTrace();
            System.out.println("roomcontroller 오류");
        }
        return true;
    }
    
    
}
