/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.projects.hms.view;

import cse.projects.hms.controller.ResCheckController;
import cse.projects.hms.controller.RoomController;
import cse.projects.hms.dao.reservation.ResDao;
import cse.projects.hms.dto.reservation.CustomertableClickcellDto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ij944
 */
public class ReservationCheckScreen extends javax.swing.JFrame {

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
        customerdatatable.getColumnModel().getColumn(5).setPreferredWidth(140);
        customerdatatable.getColumnModel().getColumn(6).setPreferredWidth(140);
        customerdatatable.getColumnModel().getColumn(1).setPreferredWidth(180);
        customerdatatable.getColumnModel().getColumn(2).setPreferredWidth(130);
        customerdatatable.getColumnModel().getColumn(8).setPreferredWidth(130);
        customerdatatable.getColumnModel().getColumn(9).setPreferredWidth(200);
        customerdatatable.getColumnModel().getColumn(10).setPreferredWidth(150);
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

    private void settable_searchdata() {
        String txtsearchroomnum = searchdata.getText();
        String txtsearchname = name.getText();
        RoomController res = new RoomController(txtsearchroomnum, txtsearchname);
        DefaultTableModel Model = (DefaultTableModel) customerdatatable.getModel();
        String[] Line = res.searchRoomdata();
        Model.setRowCount(0);
        for (int i = 0; i < Line.length; i++) {
            String[] dataRow = Line[i].toString().split(",");
            Model.addRow(dataRow);
        }
    }

    // JTable 객체를 반환하는 Getter 메서드
    public JTable getCustomerDataTable() {
        return customerdatatable;
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
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customerdatatable.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        customerdatatable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "예약자", "전화번호", "객실 타입", "객실 호수", "객실 인원", "체크인", "체크아웃", "누적요금", "결제수단", "카드번호", "객실상태"
            }
        ));
        customerdatatable.setEditingColumn(0);
        customerdatatable.setEditingRow(0);
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

        BUTT_goback.setText("뒤로 가기");
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

        BUTT_reset.setText("재설정");
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

        jLabel2.setText("예약자:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1151, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BUTT_reservation, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BUTT_modify, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BUTT_reservationcancel)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchdata, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(name))
                .addGap(18, 18, 18)
                .addComponent(BUTT_enter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BUTT_reset)
                .addGap(18, 18, 18)
                .addComponent(BUTT_goback)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BUTT_goback)
                                    .addComponent(BUTT_reset)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(searchdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(BUTT_enter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BUTT_reservationcancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BUTT_reservation, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BUTT_modify, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        if (customerdatatable.getSelectedRow() != -1) {
            ResCheckController res = new ResCheckController();
            int rowcount = customerdatatable.getSelectedRow();
            res.CancelSelectedcell(customerdatatable.getValueAt(rowcount, 3).toString(), customerdatatable.getValueAt(rowcount, 0).toString(), customerdatatable.getValueAt(rowcount, 1).toString());
            res.cancelData();
            JOptionPane.showMessageDialog(null, "예약이 성공적으로 취소 되었습니다.");
        } else
            JOptionPane.showMessageDialog(null, "취소할 테이블을 선택해주세요.");
    }//GEN-LAST:event_BUTT_reservationcancelActionPerformed

    private void BUTT_gobackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_gobackActionPerformed
        // TODO add your handling code here:
        MainScreen mainscreen = new MainScreen();
        mainscreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_BUTT_gobackActionPerformed

    private void BUTT_enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_enterActionPerformed
        if (!"".equals(searchdata.getText()) && !"".equals(name.getText())) {
            settable_searchdata();
        } else
            JOptionPane.showMessageDialog(null, "객실호수를 입력해주세요.");
    }//GEN-LAST:event_BUTT_enterActionPerformed

    private void BUTT_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_resetActionPerformed
        // TODO add your handling code here:
        DefaultTableModel Model = (DefaultTableModel) customerdatatable.getModel();
        Model.setRowCount(0);
        initializeCoustomerData();
    }//GEN-LAST:event_BUTT_resetActionPerformed

    private void BUTT_modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_modifyActionPerformed
        // TODO add your handling code here:
        if (customerdatatable.getSelectedRow() != -1) {
            int row = customerdatatable.getSelectedRow();
            TableModel data = customerdatatable.getModel();

            String name = (String) data.getValueAt(row, 0);
            String phone = (String) data.getValueAt(row, 1);
            String roomtype = (String) data.getValueAt(row, 2);
            String roomnumber = (String) data.getValueAt(row, 3);
            String people = (String) data.getValueAt(row, 4);
            String checkin = (String) data.getValueAt(row, 5);
            String checkout = (String) data.getValueAt(row, 6);
            String money = (String) data.getValueAt(row, 7);
            String payment = (String) data.getValueAt(row, 8);
            String cardnum = (String) data.getValueAt(row, 9);
            CustomertableClickcellDto selectUser = new CustomertableClickcellDto(name, phone, roomtype, roomnumber, people, checkin, checkout, money, payment, cardnum);

            ReservationModifyScreen res = new ReservationModifyScreen(selectUser);
            res.setVisible(true);
            setVisible(false);
        } else
            JOptionPane.showMessageDialog(null, "수정할 테이블을 클릭해주세요.");
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField searchdata;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param e
     * @return
     */
}
