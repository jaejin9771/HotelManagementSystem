/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.projects.hms.controller;

import cse.projects.hms.view.ReservationScreen;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ij944
 */
public class PaymentController {
    public void changeMoney(String userdata, String roomnum,String username, String phonenumber) {//요금 0으로 바꾸기 
        String line;
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if (roomnum.equals(row[3]) && username.equals(row[0]) && phonenumber.equals(row[1])) {
                    row[7] = Integer.toString(0);
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
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("선결제 요금 수정 중 오류가 발생했습니다.");
        }
    }

    public void payLaterRoomservice(String roomnum, String sum) { //룸서비스 나중에 결제 메서드
        List<String> lines = new ArrayList<>();
        String fileName = "data/UserData.txt";
        String userdata = null;
        File file = new File(fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (roomnum.equals(row[3])) {
                    userdata = line;
                    continue;
                }
                lines.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String lineToWrite : lines) {
                writer.write(lineToWrite);
                writer.newLine();
            }
            if (userdata != null) {
                String[] row = userdata.split(",");
                int oldSum = Integer.parseInt(row[7]); // 기존 합계 값
                int newSum = oldSum + Integer.parseInt(sum); // 새로운 합계 값
                row[7] = String.valueOf(newSum); // 업데이트된 합계 값으로 변경
                String updatedUserData = String.join(",", row);
                writer.write(updatedUserData);
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
