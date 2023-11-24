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
public class RoomServiceDataController {

    public boolean checkData(String name, String phonenum, String roomnum) { //만약 데이터파일에 있는 정보인지 확인
        String fileName = "data/RoomServiceData.txt";
        File file = new File(fileName);
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if (name.equals(row[0]) && phonenum.equals(row[1]) && roomnum.equals(row[2])) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addRoomServiceData(String dataBuilder, String name, String phonenum, String roomnum) { //데이터파일에 있는 정보라면
        String fileName = "data/RoomServiceData.txt";
        File file = new File(fileName);
        String line;
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if (name.equals(row[0]) && phonenum.equals(row[1]) && roomnum.equals(row[2])) {
                    row[4] = dataBuilder;
                    line = String.join(",", row);
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
        }
    }

    public void putRoomServiceDate(String data) { //데이터파일에 없는 정보라면
        String fileName = "data/RoomServiceData.txt";
        File file = new File(fileName);
        String line;
        List<String> lines = new ArrayList<>();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
