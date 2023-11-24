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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ij944
 */
public class ResCheckController {

    private CustomertableClickcellDto selectusers;
    private String txtsearchroomnum;
    private String selectuser;
    private String selectuserr;

    //private String selectedM_Roomnum;
    public ResCheckController() {

    }

    public ResCheckController(CustomertableClickcellDto ctcDto) {
        selectuserr = ctcDto.getName() + "," + ctcDto.getPhone() + "," + ctcDto.getRoomtype() + "," + ctcDto.getRoomnum() + "," + ctcDto.getPeople() + "," + ctcDto.getCheckin() + "," + ctcDto.getCheckout() + "\n";
    }

    private String selectedRoomnum;
    private String selectedname;
    private String selectedphone;

    public void CancelSelectedcell(String roomnum, String name, String phone) {
        this.selectedRoomnum = roomnum;
        this.selectedname = name;
        this.selectedphone = phone;
    }

    public boolean cancelData() {
        String line;
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if (selectedRoomnum.equals(row[3]) && selectedname.equals(row[0]) && selectedphone.equals(row[1])) {
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

    public void modifyUserdata(String selectedValue, String modifysell, String phone, String name) {
        String line;
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file,true))) {
            writer.write(modifysell);
        } catch (IOException ex) {
            System.out.println("예약정보 수정 중 오류가 발생했습니다.");
        }
    }

    public List<String> checkResDate(String checkintime, String checkouttime) {//예약화면에서 체크인 체크아웃 날짜 간격 구하기
        LocalDate currentDate = LocalDate.now();
        List<String> lines = new ArrayList<>();
        DateTimeFormatter checkinFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate rescheckin = LocalDate.parse(checkintime, checkinFormatter);
        LocalDate rescheckout = LocalDate.parse(checkouttime, checkinFormatter);

        while (!rescheckin.isAfter(rescheckout)) {
            lines.add(rescheckin.toString());
            rescheckin = rescheckin.plusDays(1);
        }
        System.out.println(lines);
        return lines;
    }

    public List<String> checkmodifiedDate(String checkintime, String checkouttime) {//예약수정화면에서 체크인 체크아웃 날짜 간격 구하기
        LocalDate currentDate = LocalDate.now();
        List<String> lines = new ArrayList<>();
        DateTimeFormatter checkinFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate rescheckin = LocalDate.parse(checkintime, checkinFormatter);
        LocalDate rescheckout = LocalDate.parse(checkouttime, checkinFormatter);

        while (!rescheckin.isAfter(rescheckout)) {
            lines.add(rescheckin.toString());
            rescheckin = rescheckin.plusDays(1);
        }
        return lines;
    }

    public List<String> checkDataDate(String roomnum) {//데이터파일에서 방번호가 같은 체크인 체크아웃 날짜 간격 구하기
        String line;
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if (roomnum.equals(row[3])) {
                    String datacheckin = row[5];
                    String datacheckout = row[6];
                    LocalDate currentDate = LocalDate.now();
                    DateTimeFormatter checkinFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate rescheckin = LocalDate.parse(datacheckin, checkinFormatter);
                    LocalDate rescheckout = LocalDate.parse(datacheckout, checkinFormatter);

                    while (!rescheckin.isAfter(rescheckout)) {
                        lines.add(rescheckin.toString());
                        rescheckin = rescheckin.plusDays(1);
                    }
                }
            }
        } catch (IOException e) {
        }

        return lines;
    }
}
