/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.projects.hms.controller;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    private String rescheckout;
    private String formatedNow;
    private int totalFee;

    public CheckOutController(String name, String phone, String roomnum, int totalFee) {
        this.name = name;
        this.phone = phone;
        this.roomnum = roomnum;
        this.totalFee = totalFee;
    }

    public CheckOutController(String rescheckout, String formatedNow) {
        this.rescheckout = rescheckout;
        this.formatedNow = formatedNow;
    }

    public String[] sendCheckoutData() {
        String line;
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
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

    public boolean deleteData() {
        String line;
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals(name) && row[1].equals(phone) && row[3].equals(roomnum) && row[10].equals("full room")) {
                    String receipt = row[5] + "," + row[6] + "," + Integer.toString(totalFee);
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

    public int calculateDate() {
        int difference = 0;
        LocalDate date1 = LocalDate.parse(rescheckout);
        LocalDate date2 = LocalDate.parse(formatedNow);
        long daysDifference = ChronoUnit.DAYS.between(date2, date1);
        if (rescheckout.equals(formatedNow)) {
            difference = 0;
        } else {
            difference = (int) daysDifference;
        }
        return difference;
    }

    public String calculateMoney(int difference) {
        int money = 0;
        for (int i = difference; i < 0; i++) {
            money += 50000;
        }
        return Integer.toString(money);
    }
}
