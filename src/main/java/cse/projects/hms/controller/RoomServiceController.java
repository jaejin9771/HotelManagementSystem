/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.projects.hms.controller;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ij944
 */
public class RoomServiceController {

    public boolean checkRoomService(String roomnum, String name, String phonenumber) {
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");

                if (roomnum.equals(row[3]) && "full room".equals(row[10]) && name.equals(row[0]) && phonenumber.equals(row[1])) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("룸서비스 오류");

        }
        return false;
    }

    public String[] sendRoomService(String roomnum,String name, String phonenumber) { //룸서비스화면에서 받은 객실호수와 데이터파일이 같은지 확인한 후 고객정보 리턴
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if (roomnum.equals(row[3])) {
                    return row;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
