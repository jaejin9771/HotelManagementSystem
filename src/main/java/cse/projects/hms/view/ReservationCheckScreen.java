/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.projects.hms.view;

import cse.projects.hms.controller.ResCheckController;
import cse.projects.hms.controller.RoomController;
import cse.projects.hms.dao.reservation.ResDao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ij944
 */
public class ReservationCheckScreen extends javax.swing.JFrame {

    String roomnum = null;

    /**
     * Creates new form ReservaionCheck
     */
    public ReservationCheckScreen() {
        initComponents();
        initializeCoustomerData();
        setLocationRelativeTo(null);
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
        ResCheckController res = new ResCheckController();
        String roomnum = null;
        if (searchdata.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "빈 객실입니다.");
            return false;
        }

        for (int i = 0; i < res.checkResroom().size(); i++) {
            if (res.checkResroom().get(i).equals(searchdata.getText())) {
                roomnum = searchdata.getText();
                return true;
            }
        }

        JOptionPane.showMessageDialog(null, "해당 객실이 없습니다.");
        return false;
    }

    private void settable_searchdata() {
        String txtsearchroomnum = searchdata.getText();
        ResCheckController res = new ResCheckController(txtsearchroomnum);
        DefaultTableModel Model = (DefaultTableModel) customerdatatable.getModel();
        if (roomDataCheck() == true) {
            Model.setRowCount(0);
            String[] Line = res.searchRoomdata();
            for (int i = 0; i < Line.length; i++) {
                String[] dataRow = Line[i].toString().split(",");
                Model.addRow(dataRow);
            }
        }
    }
//--------------------------------------------------------------------------------------------------- 예약취소기능

    public String selectrow() {//JTable에서 선택한 행의 객실번호를 리턴함
        int rowcount = customerdatatable.getSelectedRow();
        String selectroomnum = customerdatatable.getValueAt(rowcount, 3).toString();
        System.out.println(selectroomnum);
        return selectroomnum;
    }

    public void removeseltable() {
        ResCheckController canceldata = new ResCheckController();
        if (canceldata.cancelData() == true) {
            DefaultTableModel Model = (DefaultTableModel) customerdatatable.getModel();
            if (customerdatatable.getSelectedRow() != -1) {
                Model.removeRow(customerdatatable.getSelectedRow());
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
        BUTT_reset = new javax.swing.JButton();
        BUTT_modify = new javax.swing.JButton();

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

        BUTT_reset.setText("reset");
        BUTT_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_resetActionPerformed(evt);
            }
        });

        BUTT_modify.setFont(new java.awt.Font("굴림", 0, 20)); // NOI18N
        BUTT_modify.setText("예약수정");
        BUTT_modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_modifyActionPerformed(evt);
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
                .addComponent(searchdata, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BUTT_enter)
                    .addComponent(BUTT_reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BUTT_goback)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BUTT_reservation, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BUTT_modify, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BUTT_reservationcancel)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(BUTT_goback))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(searchdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addComponent(BUTT_enter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BUTT_reset)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(BUTT_reservation, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BUTT_reservationcancel, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(BUTT_modify, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
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
        settable_searchdata();
    }//GEN-LAST:event_BUTT_enterActionPerformed

    private void BUTT_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_resetActionPerformed
        // TODO add your handling code here:
        DefaultTableModel Model = (DefaultTableModel) customerdatatable.getModel();
        Model.setRowCount(0);
        initializeCoustomerData();
    }//GEN-LAST:event_BUTT_resetActionPerformed

    private void BUTT_modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_modifyActionPerformed
        // TODO add your handling code here:
        ReservationModifyScreen res = new ReservationModifyScreen();
        res.setVisible(true);
        dispose();
    }//GEN-LAST:event_BUTT_modifyActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUTT_enter;
    private javax.swing.JButton BUTT_goback;
    private javax.swing.JButton BUTT_modify;
    private javax.swing.JButton BUTT_reservation;
    private javax.swing.JButton BUTT_reservationcancel;
    private javax.swing.JButton BUTT_reset;
    private javax.swing.JTable customerdatatable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchdata;
    // End of variables declaration//GEN-END:variables

}
