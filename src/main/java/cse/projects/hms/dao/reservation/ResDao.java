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

    String[] userInfo = null;

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
        List<String> userDataList=new ArrayList<>();
        try(BufferedReader output = new BufferedReader(new FileReader(file))){
            String line;
            while((line=output.readLine())!=null){
                userDataList.add(line);
            }
        }catch(IOException e){
            System.out.println("오류검출");
        }
        return userDataList.toArray(new String[0]);
    }
    public List<String> resroomCheck() { //예약된 객실호수만 읽는 메서드
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

    public void roomSearch() { //검색된 객실호수의 고객정보 찾기 
        ReservaionCheck ress = new ReservaionCheck();
        int linecount=0;
        int currentLineNumber=0;
        String fileName = "data/UserData.txt";
        File file = new File(fileName);
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                linecount++;
                System.out.println(ress.txt_searchroomnum());
                if(ress.txt_searchroomnum()==row[3]){
                    break;
                }
            }
            
            while ((line = br.readLine()) != null) {
                currentLineNumber++;

                // 현재 라인 번호가 읽고자 하는 라인 번호와 일치하는 경우
                if (currentLineNumber == linecount) {
                    //System.out.println(line);
                    break;
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
