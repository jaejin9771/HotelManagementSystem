/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.projects.hms.controller;

import java.io.*;
import java.util.*;

/**
 *
 * @author ij944
 */
public class RoomServiceController {
    public boolean checkRoomService(String roomnum){
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if(!roomnum.equals(row[3])){
                    return false;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return true;
    }
    public String sendRoomService(String roomnum){ //룸서비스화면에서 받은 객실호수와 데이터파일이 같은지 확인한 후 고객정보 리턴
        String roomdataList=null;
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if(roomnum.equals(row[3])){
                    roomdataList = line;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return roomdataList;
    }
}
