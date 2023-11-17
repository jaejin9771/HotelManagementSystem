/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.projects.hms.view;

import cse.projects.hms.controller.RoomController;
import cse.projects.hms.dao.reservation.ResDao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ij944
 */
public class ReservaionCheck extends javax.swing.JFrame {

    String roomnum = null;

    /**
     * Creates new form ReservaionCheck
     */
    public ReservaionCheck() {
        initComponents();
        initializeCoustomerData();
    }

    private void controlColummSize() {
        customerdatatable.getColumnModel().getColumn(0).setPreferredWidth(100);
        customerdatatable.getColumnModel().getColumn(5).setPreferredWidth(350);
        customerdatatable.getColumnModel().getColumn(6).setPreferredWidth(350);
        customerdatatable.getColumnModel().getColumn(1).setPreferredWidth(180);
        customerdatatable.getColumnModel().getColumn(2).setPreferredWidth(130);
    }


    private void initializeCoustomerData() {
        ResDao res = new ResDao();
        controlColummSize();
        DefaultTableModel Model = (DefaultTableModel) customerdatatable.getModel();
        String[] Line = res.readAll(); //=데이터
        for (int i = 0; i < Line.length; i++) {
            String[] dataRow = Line[i].toString().split(",");
            Model.addRow(dataRow);
        }
    }

    private boolean roomDataCheck() {
        RoomController res = new RoomController();
        String roomnum = null;
        if (searchdata.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "빈 객실입니다.");
            return false;
        }

        for (int i = 0; i < res.resroomCheck().size(); i++) {
            if (res.resroomCheck().get(i).equals(searchdata.getText())) {
                roomnum = searchdata.getText();
                return true;
            }
        }

        JOptionPane.showMessageDialog(null, "해당 객실이 없습니다.");
        return false;
    }

    private void settablesearchdata() {
        String txtsearchroomnum = searchdata.getText();
        RoomController res = new RoomController(txtsearchroomnum);
        DefaultTableModel Model = (DefaultTableModel) customerdatatable.getModel();
        if (roomDataCheck() == true) {
            Model.setRowCount(0);
            String[] Line = res.roomdatasearch();
            for (int i = 0; i < Line.length; i++) {
                String[] dataRow = Line[i].toString().split(",");
                Model.addRow(dataRow);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        customerdatatable = new javax.swing.JTable();
        searchdata = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BUTT_reservation = new javax.swing.JButton();
        BUTT_reservationcancel = new javax.swing.JButton();
        BUTT_goback = new javax.swing.JButton();
        BUTT_enter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customerdatatable.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        customerdatatable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "예약자", "전화번호", "객실 타입", "객실 호수", "객실 인원", "체크인", "체크아웃"
            }
        ));
        customerdatatable.setRowHeight(35);
        jScrollPane1.setViewportView(customerdatatable);

        jLabel1.setText("객실검색:");

        BUTT_reservation.setFont(new java.awt.Font("굴림", 0, 20)); // NOI18N
        BUTT_reservation.setText("예약");
        BUTT_reservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_reservationActionPerformed(evt);
            }
        });

        BUTT_reservationcancel.setFont(new java.awt.Font("굴림", 0, 20)); // NOI18N
        BUTT_reservationcancel.setText("예약취소");
        BUTT_reservationcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_reservationcancelActionPerformed(evt);
            }
        });

        BUTT_goback.setText("goback");
        BUTT_goback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_gobackActionPerformed(evt);
            }
        });

        BUTT_enter.setText("enter");
        BUTT_enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_enterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(searchdata, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BUTT_enter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BUTT_goback)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BUTT_reservation, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(BUTT_reservationcancel)
                .addGap(18, 18, 18))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(BUTT_goback)
                    .addComponent(BUTT_enter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BUTT_reservationcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BUTT_reservation, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BUTT_reservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_reservationActionPerformed
        // TODO add your handling code here:
        RoomScreen roomscreen = new RoomScreen();
        roomscreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_BUTT_reservationActionPerformed

    private void BUTT_reservationcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_reservationcancelActionPerformed
        JOptionPane.showMessageDialog(null, "예약이 성공적으로 취소 되었습니다.");
    }//GEN-LAST:event_BUTT_reservationcancelActionPerformed

    private void BUTT_gobackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_gobackActionPerformed
        // TODO add your handling code here:
        MainScreen mainscreen = new MainScreen();
        mainscreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_BUTT_gobackActionPerformed

    private void BUTT_enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_enterActionPerformed
        String txtsearchroomnum = searchdata.getText();
        RoomController res = new RoomController(txtsearchroomnum);
        roomDataCheck();
        settablesearchdata();
    }//GEN-LAST:event_BUTT_enterActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUTT_enter;
    private javax.swing.JButton BUTT_goback;
    private javax.swing.JButton BUTT_reservation;
    private javax.swing.JButton BUTT_reservationcancel;
    private javax.swing.JTable customerdatatable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchdata;
    // End of variables declaration//GEN-END:variables

}
