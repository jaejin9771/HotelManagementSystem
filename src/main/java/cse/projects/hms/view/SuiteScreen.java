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
public class SuiteScreen extends javax.swing.JFrame implements ActionListener {

    private RoomController rc = new RoomController();

    /**
     * Creates new form Sweetscreen
     */
    public SuiteScreen() {
        initComponents();
        initializeRoomButtons();
        setLocationRelativeTo(null);
    }

    private void initializeRoomButtons() {
        // 모든 버튼을 배열에 추가
        JButton[] roomButtons = {
            R_301, R_302, R_303, R_304, R_305,
            R_311, R_312, R_313, R_314, R_315,
            R_321, R_322, R_323, R_324, R_325,
            R_331, R_332, R_333, R_334, R_335,
            R_341, R_342, R_343, R_344, R_345,};

        // 각 버튼에 ActionListener 등록
        for (JButton roomButton : roomButtons) {
            roomButton.addActionListener(this);
        }

        // 각 버튼에 대해 예약 상태 확인 및 비활성화 처리
        for (int i = 0; i < roomButtons.length; i++) {
            int tensDigit = i / 5;
            // 101부터 시작하도록 수정
            int roomNumber = 301 + tensDigit * 10 + i % 5;
            if (rc.isEmptyRoom(Integer.toString(roomNumber))) { 
            } else {
               roomButtons[i].setEnabled(false);
           }
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

        R_332 = new javax.swing.JButton();
        R_333 = new javax.swing.JButton();
        R_301 = new javax.swing.JButton();
        R_302 = new javax.swing.JButton();
        R_344 = new javax.swing.JButton();
        R_303 = new javax.swing.JButton();
        R_345 = new javax.swing.JButton();
        R_304 = new javax.swing.JButton();
        R_311 = new javax.swing.JButton();
        R_305 = new javax.swing.JButton();
        R_312 = new javax.swing.JButton();
        R_341 = new javax.swing.JButton();
        R_342 = new javax.swing.JButton();
        R_313 = new javax.swing.JButton();
        R_343 = new javax.swing.JButton();
        R_314 = new javax.swing.JButton();
        R_315 = new javax.swing.JButton();
        R_321 = new javax.swing.JButton();
        R_322 = new javax.swing.JButton();
        R_323 = new javax.swing.JButton();
        R_324 = new javax.swing.JButton();
        R_325 = new javax.swing.JButton();
        R_334 = new javax.swing.JButton();
        R_335 = new javax.swing.JButton();
        R_331 = new javax.swing.JButton();
        BUTT_goback = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        R_332.setText("332");

        R_333.setText("333");

        R_301.setText("301");

        R_302.setText("302");

        R_344.setText("344");
        R_344.setToolTipText("");

        R_303.setText("303");

        R_345.setText("345");

        R_304.setText("304");

        R_311.setText("311");

        R_305.setText("305");

        R_312.setText("312");

        R_341.setText("341");

        R_342.setText("342");

        R_313.setText("313");

        R_343.setText("343");

        R_314.setText("314");

        R_315.setText("315");

        R_321.setText("321");

        R_322.setText("322");

        R_323.setText("323");

        R_324.setText("324");

        R_325.setText("325");

        R_334.setText("334");

        R_335.setText("335");

        R_331.setText("331");

        BUTT_goback.setText("뒤로 가기");
        BUTT_goback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_gobackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel1.setText("*Suite 객실 기본요금 : 250,000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(R_301, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(R_302, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(R_303, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(R_311, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(R_312, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(R_313, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(R_321, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(R_322, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(R_323, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(R_331, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(R_332, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(R_333, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(R_341, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(R_342, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(R_343, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(R_304, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_314, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_324, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_334, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_344, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(R_345, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_335, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_325, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_315, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_305, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BUTT_goback)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BUTT_goback)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R_301, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_302, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_303, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_304, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_305, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R_311, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_312, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_313, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_314, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_315, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R_321, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_322, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_323, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_324, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_325, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R_331, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_332, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_333, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_334, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_335, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R_341, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_342, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_343, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_344, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R_345, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
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
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (!clickedButton.isEnabled()) {
            // 버튼이 비활성화되어 있으면(이미 예약된 방)
            // 아무 동작도 하지 않음
            return;
        }
        String roomtype = "Suite";
        String roomnum = clickedButton.getText();
        ReservationScreen reservationscreen = new ReservationScreen(roomtype,roomnum);
        reservationscreen.setVisible(true);
        dispose();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUTT_goback;
    private javax.swing.JButton R_301;
    private javax.swing.JButton R_302;
    private javax.swing.JButton R_303;
    private javax.swing.JButton R_304;
    private javax.swing.JButton R_305;
    private javax.swing.JButton R_311;
    private javax.swing.JButton R_312;
    private javax.swing.JButton R_313;
    private javax.swing.JButton R_314;
    private javax.swing.JButton R_315;
    private javax.swing.JButton R_321;
    private javax.swing.JButton R_322;
    private javax.swing.JButton R_323;
    private javax.swing.JButton R_324;
    private javax.swing.JButton R_325;
    private javax.swing.JButton R_331;
    private javax.swing.JButton R_332;
    private javax.swing.JButton R_333;
    private javax.swing.JButton R_334;
    private javax.swing.JButton R_335;
    private javax.swing.JButton R_341;
    private javax.swing.JButton R_342;
    private javax.swing.JButton R_343;
    private javax.swing.JButton R_344;
    private javax.swing.JButton R_345;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
