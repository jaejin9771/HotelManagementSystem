/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.projects.hms.dao.reservation;

import cse.projects.hms.dto.reservation.ResDto;
import cse.projects.hms.view.ReservationCheckScreen;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *
 * @author 재진
 */
public class ResDao {

    public void insert(ResDto resDto) {
        // 예약 정보 저장하는 파일 입출력 코드
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        try (BufferedWriter output = new BufferedWriter(new FileWriter(file, true))) {
            output.write(resDto.toString());
            output.newLine();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("insert 오류");
        }
    }

    public String[] readAll() {
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        List<String> userDataList = new ArrayList<>();
        try (BufferedReader output = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = output.readLine()) != null) {
                userDataList.add(line);
            }
        } catch (IOException e) {
            System.out.println("오류검출");
        }
        return userDataList.toArray(new String[0]);
    }

    public int checkPeopleInDate(LocalDate startDate, LocalDate endDate) {

        int peopleNum = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("data/UserData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] reservation = line.split(",");

                LocalDate reservationCheckin = LocalDate.parse(reservation[5], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalDate reservationCheckout = LocalDate.parse(reservation[6], DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                if (reservationCheckin.isBefore(endDate) && reservationCheckout.isAfter(startDate)) {
                    peopleNum += Integer.parseInt(reservation[4]);
                }
            }
            System.out.println("예상 인원수 : " + peopleNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return peopleNum;
    }

    public int checkRoomInDate(LocalDate startDate, LocalDate endDate) {

        int num = 0; // 사용 방 갯수
        try (BufferedReader reader = new BufferedReader(new FileReader("data/UserData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] reservation = line.split(",");

                LocalDate reservationCheckin = LocalDate.parse(reservation[5], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalDate reservationCheckout = LocalDate.parse(reservation[6], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                System.out.println("reservationCheckin : " + reservationCheckin);
                System.out.println("reservationCheckout : " + reservationCheckout);

                if (reservationCheckin.isBefore(endDate) && reservationCheckout.isAfter(startDate)) {
                    num++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return num;
    }

    public void insertReceipt(String cInDate, String cOutDate, String totalFee, String people) {
        String fileName = "data/receipt.txt";
        String receipt = cInDate + "," + cOutDate + "," + totalFee + "," + people;
        File file = new File(fileName);
        try (BufferedWriter output = new BufferedWriter(new FileWriter(file, true))) {
            output.write(receipt);
            output.newLine();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("insertReceipt 오류");
        }
    }

    public String[] readReceipt(LocalDate startDate, LocalDate endDate) {
        int sum = 0;
        int num = 0;
        int people = 0;
        String[] resultReceipt = new String[3];
        try (BufferedReader reader = new BufferedReader(new FileReader("data/receipt.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] receipt = line.split(",");
                
                LocalDate receiptCheckIn = LocalDate.parse(receipt[0], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalDate receiptCheckOut = LocalDate.parse(receipt[1], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                System.out.println("receiptCheckin : " + receiptCheckIn);
                System.out.println("receiptCheckout : " + receiptCheckOut);
                
                if (receiptCheckIn.isBefore(endDate) && receiptCheckOut.isAfter(startDate)) {
                    sum += Integer.parseInt(receipt[2]);
                    num++;
                    people += Integer.parseInt(receipt[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        resultReceipt[0] = Integer.toString(sum);
        System.out.println("ResDao resultReceipt[0] : " +resultReceipt[0]);
        resultReceipt[1] = Integer.toString(num);
        resultReceipt[2] = Integer.toString(people);
        return resultReceipt;
    }
}
