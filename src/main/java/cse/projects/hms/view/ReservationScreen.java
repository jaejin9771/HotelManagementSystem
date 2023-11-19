/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.projects.hms.view;

import cse.projects.hms.dao.reservation.ResDao;
import cse.projects.hms.dto.reservation.ResDto;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author ij944
 */
public class ReservationScreen extends javax.swing.JFrame {

    private String roomnum;
    private String roomtype;
    private ResDao resdao = new ResDao();

    /**
     * Creates new form ReservationScreen
     */
    public ReservationScreen(String roomtype, String roomnum) {
        initComponents();
        this.roomtype = roomtype;
        this.roomnum = roomnum;
        initializeroom();
        initializerestriction();
    }

    public ReservationScreen() {
        initComponents();
        initializeroom();
        initializerestriction();
        setLocationRelativeTo(null);
    }

    private void initializeroom() {
        TEXT_roomtype.setFont(new java.awt.Font("굴림", 0, 18));
        TEXT_roomtype.setText(roomtype);
        TEXT_roomtype.setEditable(false);
        TEXT_roomnum.setFont(new java.awt.Font("굴림", 0, 18));
        TEXT_roomnum.setText(roomnum);
        TEXT_roomnum.setEditable(false);
    }
    private void initializerestriction(){
        if(roomtype == "Standard" || roomtype == "Royal"){
            TEXT_peopleNumber.removeItemAt(4);
            TEXT_peopleNumber.removeItemAt(4);
        }
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
        BUTT_payment = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

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
        BUTT_insert.setText("확인");
        BUTT_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_insertActionPerformed(evt);
            }
        });

        BUTT_cancel.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        BUTT_cancel.setText("취소");
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

        BUTT_payment.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        BUTT_payment.setText("선결제");
        BUTT_payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_paymentActionPerformed(evt);
            }
        });

        jLabel9.setText("*16:00~23:00에 객실 체크인이 가능합니다");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BUTT_payment, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BUTT_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BUTT_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(140, 140, 140)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(TEXT_peopleNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(checkinTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(checkoutTime, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(name)
                                    .addComponent(TEXT_roomtype)
                                    .addComponent(TEXT_roomnum)
                                    .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TEXT_roomtype, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TEXT_roomnum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TEXT_peopleNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkinTime, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkoutTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BUTT_payment, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(BUTT_insert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BUTT_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BUTT_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_insertActionPerformed
        String selectedpeopleNumber = TEXT_peopleNumber.getSelectedItem().toString();
        String username = name.getText();
        String phonenumber = phoneNumber.getText();
        String checkintime = checkinTime.getDate().toString();
        String checkouttime = checkoutTime.getDate().toString();
        
        ResDto res;
        res = new ResDto(username, phonenumber, roomtype, roomnum, selectedpeopleNumber, checkintime, checkouttime);
        resdao.insert(res);


        JOptionPane.showMessageDialog(null, "예약이 성공적으로 되었습니다.");
    }//GEN-LAST:event_BUTT_insertActionPerformed

    private void BUTT_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_cancelActionPerformed
        RoomScreen roomscreen = new RoomScreen();
        roomscreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_BUTT_cancelActionPerformed

    private void BUTT_paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_paymentActionPerformed
        // TODO add your handling code here:
        PaymentScreen paymentscreen = new PaymentScreen();
        paymentscreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_BUTT_paymentActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUTT_cancel;
    private javax.swing.JButton BUTT_insert;
    private javax.swing.JButton BUTT_payment;
    private javax.swing.JComboBox<String> TEXT_peopleNumber;
    private javax.swing.JTextField TEXT_roomnum;
    private javax.swing.JTextField TEXT_roomtype;
    private com.toedter.calendar.JDateChooser checkinTime;
    private com.toedter.calendar.JDateChooser checkoutTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phoneNumber;
    // End of variables declaration//GEN-END:variables

}
