/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.projects.hms.controller;

import cse.projects.hms.dto.reservation.CustomertableClickcellDto;
import cse.projects.hms.view.ReservationCheckScreen;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ij944
 */
public class ResCheckController {
    private CustomertableClickcellDto selectusers;
    private String txtsearchroomnum;
    private String selectuser;
    //private String selectedM_Roomnum;
    public ResCheckController() {

    }
//    public ResCheckController(String roomnum) {
//        this.selectedM_Roomnum = roomnum;
//    }
    public ResCheckController(String txtsearchroomnum) {
        this.txtsearchroomnum = txtsearchroomnum;
    }
    public ResCheckController(CustomertableClickcellDto ctcDto){
        selectuser = ctcDto.getName()+","+ ctcDto.getPhone()+","+ctcDto.getRoomtype()+","+ctcDto.getRoomnum()+","+ctcDto.getPeople()+","+ctcDto.getCheckin()+","+ctcDto.getCheckout()+"\n";
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
    
    private String selectedRoomnum;
    public void CancelSelectedcell(String roomnum) {
        selectedRoomnum = roomnum;
    }

    public boolean cancelData() {
        String line;
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if (selectedRoomnum.equals(row[3])) {
                    continue;
                }
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String lineToWrite : lines) {
                writer.write(lineToWrite);
                writer.newLine();
            }
            System.out.println("예약이 성공적으로 취소 되었습니다.");
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ResCheckController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.out.println("예약 취소 중 오류가 발생했습니다.");
        }
        return false;
    }
    
    private String selectedM_Roomnum;
    public void modifySelectedcell(String roomnum) {
        this.selectedM_Roomnum = roomnum;
        System.out.println(selectedM_Roomnum); // 실행됨.
    }
    //public void modifyUserdata(CustomertableClickcellDto ctcDto,String selectedValue)
    public boolean modifyUserdata(String selectedValue){
        String line;
        System.out.println(this.selectedM_Roomnum); 
        
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if (selectedM_Roomnum.equals(row[3])) {
                    continue;
                }
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String lineToWrite : lines) {
                writer.write(lineToWrite);
                writer.newLine();
                writer.write(selectuser);
            }
            System.out.println("예약정보가 성공적으로 수정되었습니다.");
        } catch (IOException ex) {
            Logger.getLogger(ResCheckController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.out.println("예약정보 수정 중 오류가 발생했습니다.");
        }
        return true;
    }
}
