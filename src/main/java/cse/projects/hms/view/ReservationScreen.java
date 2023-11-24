/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.projects.hms.view;

import cse.projects.hms.controller.PaymentController;
import cse.projects.hms.controller.ResCheckController;
import cse.projects.hms.controller.RoomController;
import cse.projects.hms.dao.reservation.ResDao;
import cse.projects.hms.dto.reservation.ResDto;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author ij944
 */
public class ReservationScreen extends javax.swing.JFrame {

    private int money = 0;
    private String roomnum;
    private String roomtype;
    private ResDao resdao = new ResDao();

    boolean isOtherButtonClicked = false;
    private boolean isButtonClicked = false;

    /**
     * Creates new form ReservationScreen
     */
    public ReservationScreen(String roomtype, String roomnum) {
        initComponents();
        this.roomtype = roomtype;
        this.roomnum = roomnum;
        initializeroom();
        initializerestriction();
        setLocationRelativeTo(null);
        blockCardnumber();
    }

    public ReservationScreen() {
        initComponents();
        initializeroom();
        initializerestriction();
        setLocationRelativeTo(null);
        blockCardnumber();
    }

    private void blockCardnumber() {
        paymentmethod.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 아이템 상태가 변경될 때 호출되는 메서드
                blockCardnumber();
                if ("CreditCard".equals(paymentmethod.getSelectedItem().toString())) {
                    cardnumber.setEditable(true);
                } else {
                    cardnumber.setEditable(false);
                }
            }
        });
    }

    private void initializeroom() {
        TEXT_roomtype.setFont(new java.awt.Font("굴림", 0, 18));
        TEXT_roomtype.setText(roomtype);
        TEXT_roomtype.setEditable(false);
        TEXT_roomnum.setFont(new java.awt.Font("굴림", 0, 18));
        TEXT_roomnum.setText(roomnum);
        TEXT_roomnum.setEditable(false);
    }

    private void initializerestriction() {//객실등급에 따른 인원제한
        if (roomtype == "Standard" || roomtype == "Royal") {
            TEXT_peopleNumber.removeItemAt(4);
            TEXT_peopleNumber.removeItemAt(4);
        }
    }

    private String calculateRoomMoney() {//총 결제금액 계산함
        if (TEXT_roomtype.getText().equals("Standard")) {//객실등급에 따른 기본요금 설정
            money = 100000;
        } else if (TEXT_roomtype.getText().equals("Royal")) {
            money = 150000;
        } else if (TEXT_roomtype.getText().equals("Suite")) {
            money = 250000;
        } else if (TEXT_roomtype.getText().equals("RoyalSuite")) {
            money = 400000;
        }

        switch (TEXT_peopleNumber.getSelectedIndex()) {//인원수에 따른 추가요금 설정
            case 2:
                money += 30000;
                break;
            case 3:
                money += 60000;
                break;
            case 4:
                money += 90000;
                break;
            case 5:
                money += 120000;
                break;
            default:
                break;
        }

        switch (calculateDate()) { //체크인 날짜와 체크아웃 날짜 간의 차이 계산 후 추가요금 설정
            case 2:
                money += 50000;
                break;
            case 3:
                money += 100000;
                break;
            case 4:
                money += 150000;
                break;
            case 5:
                money += 200000;
                break;
            default:
                break;
        }
        return Integer.toString(money);//총 결제금액 반환(예약이 완료되었을 때 메시지로 뜸)
    }

    public int calculateDate() {//예상 체크인 날짜와 체크아웃 날짜를 계산하는 메서드
        // 첫번째 JCalendar에서 선택된 날짜 가져오기
        Calendar calendar1SelectedDateCalendar = checkinTime.getCalendar();
        Date calendar1SelectedDate = calendar1SelectedDateCalendar.getTime();
        LocalDate localDate1 = calendar1SelectedDate.toInstant().atZone(Calendar.getInstance().getTimeZone().toZoneId()).toLocalDate();

        // 첫번째 JCalendar에서 선택된 날짜 가져오기
        Calendar calendar2SelectedDateCalendar = checkoutTime.getCalendar();
        Date calendar2SelectedDate = calendar2SelectedDateCalendar.getTime();
        LocalDate localDate2 = calendar2SelectedDate.toInstant().atZone(Calendar.getInstance().getTimeZone().toZoneId()).toLocalDate();

        // 날짜 차이 계산
        long daysDifference = Math.abs(localDate2.toEpochDay() - localDate1.toEpochDay());
        System.out.println(daysDifference);
        return (int) daysDifference;
    }

    public boolean overlap(List<String> datadate, List<String> resdate) {

        return !datadate.stream().anyMatch(resdate::contains);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        phoneNumber = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TEXT_peopleNumber = new javax.swing.JComboBox<>();
        BUTT_insert = new javax.swing.JButton();
        BUTT_cancel = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        checkinTime = new com.toedter.calendar.JDateChooser();
        checkoutTime = new com.toedter.calendar.JDateChooser();
        TEXT_roomtype = new javax.swing.JTextField();
        TEXT_roomnum = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        payBtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        paymentmethod = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cardnumber = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("굴림", 1, 36)); // NOI18N
        jLabel1.setText("Reservaion");

        jLabel2.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        jLabel2.setText("예약자:");

        jLabel3.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        jLabel3.setText("전화번호:");

        jLabel4.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        jLabel4.setText("객실타입:");

        phoneNumber.setFont(new java.awt.Font("굴림", 0, 18)); // NOI18N

        name.setFont(new java.awt.Font("굴림", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        jLabel5.setText("객실인원:");

        jLabel6.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        jLabel6.setText("체크인:");

        jLabel7.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        jLabel7.setText("체크아웃:");

        TEXT_peopleNumber.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        TEXT_peopleNumber.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));

        BUTT_insert.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        BUTT_insert.setText("예약");
        BUTT_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_insertActionPerformed(evt);
            }
        });

        BUTT_cancel.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        BUTT_cancel.setText("뒤로 가기");
        BUTT_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_cancelActionPerformed(evt);
            }
        });

        jLabel11.setText("* 010-0000-0000");

        jLabel8.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        jLabel8.setText("객실호수:");

        TEXT_roomtype.setText("");

        TEXT_roomnum.setText("");

        jLabel9.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel9.setText("*인원 수 추가에 따른 요금: 30000");

        jLabel10.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel10.setText("* 기본 인원: 2명");

        payBtn.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        payBtn.setText("선결제");
        payBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBtnActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        jLabel12.setText("결제타입:");

        paymentmethod.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        paymentmethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CreditCard", "Cash" }));

        jLabel13.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        jLabel13.setText("카드번호:");

        cardnumber.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N

        jLabel14.setText("*0000-0000-0000-0000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TEXT_roomnum, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(TEXT_roomtype, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(phoneNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkinTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkoutTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(paymentmethod, 0, 146, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cardnumber, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(168, 168, 168)
                                .addComponent(BUTT_cancel))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TEXT_peopleNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(212, 212, 212)
                                    .addComponent(payBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(BUTT_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BUTT_cancel))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TEXT_roomtype, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TEXT_roomnum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkinTime, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(checkoutTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(paymentmethod, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cardnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TEXT_peopleNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(payBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BUTT_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BUTT_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_insertActionPerformed

        String checkintime = "";
        String checkouttime = "";

        String cardnumbers;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String selectedpeopleNumber = TEXT_peopleNumber.getSelectedItem().toString();
        String username = name.getText();
        String phonenumber = phoneNumber.getText();

        if (checkinTime.getDate() != null) {
            checkintime = dateFormat.format(checkinTime.getDate());
        }
        if (checkoutTime.getDate() != null) {
            checkouttime = dateFormat.format(checkoutTime.getDate());
        }

        String selectedpayment = paymentmethod.getSelectedItem().toString();
        if (!"".equals(cardnumber.getText())) {
            cardnumbers = cardnumber.getText();
        } else {
            cardnumbers = "현금결제";
        }
        String occupation = "empty room";
        ResCheckController check = new ResCheckController();

        if (!"".equals(name.getText()) && !"".equals(phoneNumber.getText()) && !"".equals(checkintime) && !"".equals(checkouttime)) {//모든 정보가 입력되었으면 if문 들어감
            if (overlap(check.checkDataDate(roomnum), check.checkResDate(checkintime, checkouttime))) {

                if (calculateDate() <= 5) {//체크인 날짜와 체크아웃 날짜의 차이를 계산했을 때 5이거나 5보다 작을 때 
                    ResDto res;
                    res = new ResDto(username, phonenumber, roomtype, roomnum, selectedpeopleNumber, checkintime, checkouttime, selectedpayment, cardnumbers, calculateRoomMoney(), occupation, calculateRoomMoney());
                    resdao.insert(res);
                    isButtonClicked = true;
                    JOptionPane.showMessageDialog(null, "기본객실요금은 " + calculateRoomMoney() + "원입니다.");
                    BUTT_insert.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "객실이용제한은 5일입니다.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "이미 예약된 날짜입니다.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "예약정보를 모두 입력해주세요.");
        }
    }//GEN-LAST:event_BUTT_insertActionPerformed

    private void BUTT_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_cancelActionPerformed
        RoomScreen roomscreen = new RoomScreen();
        roomscreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_BUTT_cancelActionPerformed

    private void payBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBtnActionPerformed
        String cardnumbers;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String selectedpeopleNumber = TEXT_peopleNumber.getSelectedItem().toString();
        String username = name.getText();
        String phonenumber = phoneNumber.getText();
        String checkintime = dateFormat.format(checkinTime.getDate());
        String checkouttime = dateFormat.format(checkoutTime.getDate());
        String selectedpayment = paymentmethod.getSelectedItem().toString();

        if (!"".equals(cardnumber.getText())) {
            cardnumbers = cardnumber.getText();
        } else {
            cardnumbers = "현금결제";
        }
        String occupation = "empty room";
        if (isButtonClicked) {
            // 버튼이 클릭되었을 때의 동작
            String userdata = username + ',' + phonenumber + ',' + roomtype + ',' + roomnum + ',' + selectedpeopleNumber + ',' + checkintime + ',' + checkouttime + ',' + calculateRoomMoney() + ',' + selectedpayment + ',' + cardnumbers + ',' + occupation;
            PaymentScreen pay = new PaymentScreen(userdata, roomnum, calculateRoomMoney(), phonenumber, username);
            pay.setVisible(true);
            dispose();
        } else {
            // 버튼이 클릭되지 않았을 때의 동작
            JOptionPane.showMessageDialog(null, "예약 버튼을 클릭해주세요.");
        }
    }//GEN-LAST:event_payBtnActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUTT_cancel;
    private javax.swing.JButton BUTT_insert;
    private javax.swing.JComboBox<String> TEXT_peopleNumber;
    private javax.swing.JTextField TEXT_roomnum;
    private javax.swing.JTextField TEXT_roomtype;
    private javax.swing.JTextField cardnumber;
    private com.toedter.calendar.JDateChooser checkinTime;
    private com.toedter.calendar.JDateChooser checkoutTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField name;
    private javax.swing.JButton payBtn;
    private javax.swing.JComboBox<String> paymentmethod;
    private javax.swing.JTextField phoneNumber;
    // End of variables declaration//GEN-END:variables

}
