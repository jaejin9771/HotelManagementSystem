/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.projects.hms.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ij944
 */
public class CheckInController {

    private String name;
    private String phone;
    private String roomnum;

    
    public CheckInController(){
        
    }


    public CheckInController(String name, String phone, String roomnum) {
        this.name = name;
        this.phone = phone;
        this.roomnum = roomnum;
    }

    public void modifyFullroom() { //입력된 값의 라인을 fullroom으로 수정
        String line;
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                System.out.println(name + "," + phone + "," + roomnum);
                if (row[0].equals(name) && row[1].equals(phone) && row[3].equals(roomnum)) {
                    row[10] = "full room"; // 10번째 인덱스 값을 "full room"으로 변경
                    line = String.join(",", row);// 변경된 배열을 다시 문자열로 조합
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
            System.out.println("체크인이 성공적으로 되었습니다.");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("체크인 중 오류가 발생했습니다.");
        }
    }


    public boolean checkFullroom() { //체크인 되었는지 확인하는 메서드

        String line;
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if ("full room".equals(row[10])) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean checkResroom(){ //입력된 값이 예약되었는지 확인

        String line;
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        System.out.println(name + "," + phone + "," + roomnum);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals(name) && row[1].equals(phone) && row[3].equals(roomnum)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
