/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.projects.hms.controller;

import cse.projects.hms.view.ReservationCheckScreen;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ij944
 */
public class ResCheckController {
    private String txtsearchroomnum;

    public ResCheckController() {

    }

    public ResCheckController(String txtsearchroomnum) {
        this.txtsearchroomnum = txtsearchroomnum;
    }

    public List<String> checkResroom() { //예약된 객실호수만 읽는 메서드
        String[] roomdata = null;
        List<String> roomdataList = new ArrayList<>();
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                roomdataList.add(row[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        roomdata = roomdataList.toArray(new String[0]);
        return roomdataList;
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
                if (txtsearchroomnum.equals(row[3])) {
                    break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(RoomController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                currentLineNumber++;
                String[] row = line.split(",");
                // 현재 라인 번호가 읽고자 하는 라인 번호와 일치하는 경우
                if (currentLineNumber == linecount) {
                    userDataList.add(line);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userDataList.toArray(new String[0]);
    }

    public boolean cancelData() {
        int linecount = -1;
        ReservationCheckScreen res = new ReservationCheckScreen();
        System.out.println(res.selectjtable());
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                line = br.readLine();
                if(line == "\n"){
                    linecount++;
                }
                if(linecount == res.selectjtable()){
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
