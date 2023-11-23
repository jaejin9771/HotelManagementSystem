/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.projects.hms.view;

import cse.projects.hms.controller.CheckInController;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author ij944
 */
public class CheckInScreen extends javax.swing.JFrame {

    /**
     * Creates new form CheckINScreen
     */
    public CheckInScreen() {
        initComponents();
        setLocationRelativeTo(null);
    }
    private String name;
    private String phone;
    private String roomnum;

    private static boolean isCheckinTimeValid() {
        // 현재 시간 가져오기
        LocalTime currentTime = LocalTime.now();

        // 체크인 가능한 시간 범위 설정 (아침 9시부터 24시까지)
        LocalTime checkinStartTime = LocalTime.of(9, 0);
        LocalTime checkinEndTime = LocalTime.of(23, 59);

        // 현재 시간이 체크인 가능한 범위에 있는지 확인
        return currentTime.isAfter(checkinStartTime) && currentTime.isBefore(checkinEndTime);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BUTT_goback = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtphone = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BUTT_ok = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtroomnum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BUTT_goback.setText("뒤로 가기");
        BUTT_goback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_gobackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        jLabel1.setText("예약자:");

        jLabel2.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        jLabel2.setText("전화번호:");

        txtphone.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N

        txtname.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("굴림", 1, 36)); // NOI18N
        jLabel5.setText("Check IN");

        BUTT_ok.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        BUTT_ok.setText("Check-In");
        BUTT_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_okActionPerformed(evt);
            }
        });

        jLabel3.setText("*010-0000-0000");

        jLabel4.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        jLabel4.setText("객실호수:");

        txtroomnum.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(BUTT_goback)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BUTT_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtroomnum, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(27, 27, 27)
                                    .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(49, 49, 49))))
                        .addGap(59, 59, 59))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BUTT_goback))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtroomnum, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(BUTT_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BUTT_gobackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_gobackActionPerformed
        // TODO add your handling code here:
        MainScreen mainscreen = new MainScreen();
        mainscreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_BUTT_gobackActionPerformed

    private void BUTT_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_okActionPerformed

        name = txtname.getText();
        phone = txtphone.getText();
        roomnum = txtroomnum.getText();
        CheckInController check = new CheckInController(name, phone, roomnum);
        if (txtname.getText() != null && txtphone.getText() != null && txtroomnum.getText() != null) {
            if (check.checkResroom() == true) {
                if (isCheckinTimeValid()) {
                    if (check.checkFullroom() == true) {
                        check.modifyFullroom();
                        JOptionPane.showMessageDialog(null, "체크인이 완료되었습니다.");
                        MainScreen mainscreen = new MainScreen();
                        mainscreen.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "이미 체크인 되었습니다.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "체크인 시간이 마감되었습니다.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "예약된 객실정보가 아닙니다.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "모든 정보를 입력해주세요.");
        }
    }//GEN-LAST:event_BUTT_okActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUTT_goback;
    private javax.swing.JButton BUTT_ok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtroomnum;
    // End of variables declaration//GEN-END:variables
}
