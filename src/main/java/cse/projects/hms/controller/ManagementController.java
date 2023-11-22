/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.projects.hms.controller;

import cse.projects.hms.dao.reservation.ResDao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author 재진
 */
public class ManagementController {
    public static ManagementController managementController = new ManagementController();
    
    public static ManagementController getInstance() {
        return managementController;
    }
    private static ResDao resDao = new ResDao();
    
    public int[] searchReservation(LocalDate startDate,LocalDate endDate) {
        int[] searchValue = {0,0};
        searchValue[0] = resDao.checkPeopleInDate(startDate, endDate);
        searchValue[1] = resDao.checkRoomInDate(startDate, endDate);
        return searchValue;
    }
  
}