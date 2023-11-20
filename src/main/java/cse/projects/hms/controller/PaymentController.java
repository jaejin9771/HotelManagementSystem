/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.projects.hms.controller;

import cse.projects.hms.view.ReservationScreen;
import java.io.*;
import java.util.*;

/**
 *
 * @author ij944
 */
public class PaymentController {
    public void changeMoney(String userdata, String roomnum, String money) {//요금 0으로 바꾸기 
        String line;
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if (roomnum.equals(row[3])) {
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
            writer.write(userdata +','+ money);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("선결제 요금 수정 중 오류가 발생했습니다.");
        }
    }
}
