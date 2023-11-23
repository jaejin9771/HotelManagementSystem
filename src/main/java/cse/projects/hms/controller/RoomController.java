/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.projects.hms.controller;

import cse.projects.hms.dao.reservation.ResDao;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author ij944
 */
public class RoomController {

    private String txtsearchroomnum;
    private String txtsearchname;

    public RoomController() {

    }

    public RoomController(String txtsearchroomnum, String txtsearchname) {
        this.txtsearchroomnum = txtsearchroomnum;
        this.txtsearchname = txtsearchname;
    }

    public String[] searchRoomdata() { //검색된 객실호수의 고객정보 찾기 
        int linecount = -1;
        int currentLineNumber = -1;
        List<String> userDataList = new ArrayList<>();
        String fileName = "data/UserData.txt";
        File file = new File(fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                linecount++;
                if (txtsearchroomnum.equals(row[3]) && txtsearchname.equals(row[0])) {
                    userDataList.add(line);
                }
            }
        } catch (IOException ex) {
        }
        return userDataList.toArray(new String[0]);
    }
}
