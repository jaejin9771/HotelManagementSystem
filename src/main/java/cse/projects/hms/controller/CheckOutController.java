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
public class CheckOutController {

    private String name;
    private String phone;
    private String roomnum;

    public CheckOutController(String name, String phone, String roomnum) {
        this.name = name;
        this.phone = phone;
        this.roomnum = roomnum;
    }

    public String[] sendCheckoutData() {
        String line;
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        System.out.println(name + "," + phone + "," + roomnum);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals(name) && row[1].equals(phone) && row[3].equals(roomnum) && row[10].equals("full room")) {
                    return row;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean deleteData(){
        String line;
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals(name) && row[1].equals(phone) && row[3].equals(roomnum) && row[10].equals("full room")) {
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
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }
}
