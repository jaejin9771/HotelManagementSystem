/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.projects.hms.view;

import cse.projects.hms.controller.RoomController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author ij944
 */
public class StandardScreen extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form StandardScreen
     */
    private RoomController rc = new RoomController();

    public StandardScreen() {
        initComponents();
        initializeRoomButtons();
        setLocationRelativeTo(null);
    }

    private void initializeRoomButtons() {
        // 모든 버튼을 배열에 추가
        JButton[] roomButtons = {
            R_101, R_102, R_103, R_104, R_105,
            R_111, R_112, R_113, R_114, R_115,
            R_121, R_122, R_123, R_124, R_125,
            R_131, R_132, R_133, R_134, R_135,
            R_141, R_142, R_143, R_144, R_145,};

        // 각 버튼에 ActionListener 등록
        for (JButton roomButton : roomButtons) {
            roomButton.addActionListener(this);
        }

        // 각 버튼에 대해 예약 상태 확인 및 비활성화 처리
        for (int i = 0; i < roomButtons.length; i++) {
            int tensDigit = i / 5;
            // 101부터 시작하도록 수정
            int roomNumber = 101 + tensDigit * 10 + i % 5;
            if (rc.isEmptyRoom( Integer.toString(roomNumber))){ 
            } else {
               roomButtons[i].setEnabled(false);
           }
        }
    }

    /*@Override
     public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        
        String roomnum = (String)e.getSource();
        rc.isEmptyRoom(roomnum);
        
        if(rc.isEmptyRoom(roomnum)==true){
            clickedButton.setEnabled(false);
        }
        else  {
            clickedButton.setEnabled(true);
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        R_132 = new javax.swing.JButton();
        R_133 = new javax.swing.JButton();
        R_101 = new javax.swing.JButton();
        R_102 = new javax.swing.JButton();
        R_144 = new javax.swing.JButton();
        R_103 = new javax.swing.JButton();
        R_145 = new javax.swing.JButton();
        R_104 = new javax.swing.JButton();
        R_111 = new javax.swing.JButton();
        R_105 = new javax.swing.JButton();
        R_112 = new javax.swing.JButton();
        R_141 = new javax.swing.JButton();
        R_142 = new javax.swing.JButton();
        R_113 = new javax.swing.JButton();
        R_143 = new javax.swing.JButton();
        R_114 = new javax.swing.JButton();
        R_115 = new javax.swing.JButton();
        R_121 = new javax.swing.JButton();
        R_122 = new javax.swing.JButton();
        R_123 = new javax.swing.JButton();
        R_124 = new javax.swing.JButton();
        R_125 = new javax.swing.JButton();
        R_134 = new javax.swing.JButton();
        R_135 = new javax.swing.JButton();
        R_131 = new javax.swing.JButton();
        BUTT_goback = new javax.swing.JButton();

        jButton19.setText("jButton1");

        jButton20.setText("jButton1");

        jButton1.setText("jButton1");

        jButton2.setText("jButton1");

        jButton26.setText("jButton1");

        jButton3.setText("jButton1");

        jButton27.setText("jButton1");

        jButton4.setText("jButton1");

        jButton6.setText("jButton1");

        jButton5.setText("jButton1");

        jButton7.setText("jButton1");

        jButton28.setText("jButton1");

        jButton29.setText("jButton1");

        jButton8.setText("jButton1");

        jButton30.setText("jButton1");

        jButton9.setText("jButton1");

        jButton10.setText("jButton1");

        jButton11.setText("jButton1");

        jButton12.setText("jButton1");

        jButton13.setText("jButton1");

        jButton14.setText("jButton1");

        jButton15.setText("jButton1");

        jButton16.setText("jButton1");

        jButton17.setText("jButton1");

        jButton18.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        R_132.setText("132");

        R_133.setText("133");

        R_101.setText("101");

        R_102.setText("102");

        R_144.setText("144");

        R_103.setText("103");

        R_145.setText("145");

        R_104.setText("104");

        R_111.setText("111");

        R_105.setText("105");

        R_112.setText("112");

        R_141.setText("141");

        R_142.setText("142");

        R_113.setText("113");

        R_143.setText("143");

        R_114.setText("114");
        R_114.setToolTipText("");

        R_115.setText("115");

        R_121.setText("121");

        R_122.setText("122");

        R_123.setText("123");

        R_124.setText("124");

        R_125.setText("125");
        R_125.setToolTipText("");

        R_134.setText("134");

        R_135.setText("135");

        R_131.setText("131");

        BUTT_goback.setText("뒤로 가기");
        BUTT_goback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_gobackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(R_101, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(R_102, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(R_103, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(R_111, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(R_112, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(R_113, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(R_121, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(R_122, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(R_123, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(R_131, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(R_132, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(R_133, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(R_141, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(R_142, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(R_143, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(R_104, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_114, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_124, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_134, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_144, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(R_145, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_135, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_125, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_115, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_105, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BUTT_goback)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BUTT_goback)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R_101, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_102, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_103, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_104, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_105, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R_111, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_112, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_113, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_114, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_115, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R_121, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_122, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_123, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_124, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_125, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R_131, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_132, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_133, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_134, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_135, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R_141, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_142, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_143, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_144, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_145, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BUTT_gobackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_gobackActionPerformed
        // TODO add your handling code here:
        RoomScreen reservationScreen = new RoomScreen();
        reservationScreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_BUTT_gobackActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUTT_goback;
    private javax.swing.JButton R_101;
    private javax.swing.JButton R_102;
    private javax.swing.JButton R_103;
    private javax.swing.JButton R_104;
    private javax.swing.JButton R_105;
    private javax.swing.JButton R_111;
    private javax.swing.JButton R_112;
    private javax.swing.JButton R_113;
    private javax.swing.JButton R_114;
    private javax.swing.JButton R_115;
    private javax.swing.JButton R_121;
    private javax.swing.JButton R_122;
    private javax.swing.JButton R_123;
    private javax.swing.JButton R_124;
    private javax.swing.JButton R_125;
    private javax.swing.JButton R_131;
    private javax.swing.JButton R_132;
    private javax.swing.JButton R_133;
    private javax.swing.JButton R_134;
    private javax.swing.JButton R_135;
    private javax.swing.JButton R_141;
    private javax.swing.JButton R_142;
    private javax.swing.JButton R_143;
    private javax.swing.JButton R_144;
    private javax.swing.JButton R_145;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (!clickedButton.isEnabled()) {
            // 버튼이 비활성화되어 있으면(이미 예약된 방)
            // 아무 동작도 하지 않음
            return;
        }
        String roomtype = "Standard";
        String roomnum = clickedButton.getText();
        ReservationScreen reservationscreen = new ReservationScreen(roomtype,roomnum);
        reservationscreen.setVisible(true);
        dispose();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
