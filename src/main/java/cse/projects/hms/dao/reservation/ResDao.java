/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.projects.hms.dao.reservation;

import cse.projects.hms.dto.reservation.ResDto;
import cse.projects.hms.view.ReservaionCheck;
import java.io.*;
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
}
