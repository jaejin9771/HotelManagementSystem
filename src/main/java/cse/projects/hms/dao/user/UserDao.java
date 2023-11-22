/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.projects.hms.dao.user;

import cse.projects.hms.dto.user.*;
import cse.projects.hms.dto.user.UserDto.UserBuilder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 재진
 */
public class UserDao {

    private String fileName = "data/user.txt";

    public UserDto findByIdAndPw(UserLoginDto loginDto) {
        UserDto userDto = new UserDto();

        File file = new File(fileName);

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while ((line = br.readLine()) != null) {
                String[] userInfo = line.split(","); // txt파일에 저장되어있는 아이디와 비밀번호를 나눠서 저장.

                // id pw 확인
                if (loginDto.getId().equals(userInfo[0])) {
                    if (loginDto.getPw().equals(userInfo[1])) {

                        userDto = new UserBuilder()
                                .id(loginDto.getId())
                                .pw(loginDto.getPw())
                                .usertype(userInfo[2])
                                .build();
                        return userDto;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        //없다면
        return null;
    }

    public boolean findById(String id) {

        File file = new File(fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userInfo = line.split(","); // txt파일에 저장되어있는 아이디와 비밀번호를 나눠서 저장.
                if (id.equals(userInfo[0])) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("findById 오류");
        }
        return false;
    }

    public boolean insert(UserDto userDto) {

        File file = new File(fileName);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            String line = userDto.getId() + "," + userDto.getPw() + "," + userDto.getUsertype();
            bw.newLine();
            bw.write(line);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("UserDao.insert() 오류");
        }
        return false;
    }


    public void readAll(DefaultTableModel dtm) {
        String file = "data/user.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split(",");
                dtm.addRow(userInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] selectRow(int index) {  // user.txt 파일에서 데이터 찾아서 row 반환
        String[] userInfo = null;
        int i = 0; // 인덱스 값을 카운트할 변수.
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (i == index) {
                    userInfo = line.split(",");
                    break;
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    public void modify(UserDto modifyDto, int index) {
        
        String line;
        String modifyLine = "";
        int count = -1;
        List<String> lines = new ArrayList<>();
        // 수정할 값 빼고 나머지 lines에 저장.
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                count++;
                if(count == index){
                    continue;
                }
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String lineToWrite : lines) { // lines에 넣은 값들 다시 쓰기.
                bw.write(lineToWrite);
                bw.newLine();
            }
            // 수정 값 추가하기
            line = modifyDto.getId() + "," +  modifyDto.getPw() + "," + modifyDto.getUsertype(); // 수정한 값 저장
            
            bw.write(line);
            bw.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

}
