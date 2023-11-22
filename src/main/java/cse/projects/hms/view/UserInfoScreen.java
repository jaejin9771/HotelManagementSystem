/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cse.projects.hms.view;

import cse.projects.hms.controller.UserController;
import cse.projects.hms.dao.user.UserDao;

import cse.projects.hms.dto.user.UserDto;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 재진
 */
public class UserInfoScreen extends javax.swing.JFrame {

    private UserController userController = UserController.getInstance();
    private DefaultTableModel dtm; // 테이블 모델 변수
    private UserDao userDao = new UserDao();
    private UserDto userDto;

    /**
     * Creates new form pwChangeScreen
     */
    public UserInfoScreen() {
        initComponents();
        setLocationRelativeTo(null);
        initTable();
    }

    private void initTable() {
        String[] col = {"ID", "Password", "UserType"};   // 컬럼 정보
        dtm = new DefaultTableModel(col, 0) {
            public boolean isCellEditable(int i, int c) {  // 셀 수정 불가 메서드

                return false;
            }
        };
        userTable.setModel(dtm);   // userTalbe에 dtm 설정
        userDao.readAll(dtm);  //  모든 유저 데이터 가져와서 dtm에 저장
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
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        resetBtn = new javax.swing.JButton();
        modifyBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel1.setText("User Information");

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Password", "UserType"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userTable);

        resetBtn.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        resetBtn.setText("Reset");

        modifyBtn.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        modifyBtn.setText("Modify");
        modifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(resetBtn)
                        .addGap(18, 18, 18)
                        .addComponent(modifyBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(83, 83, 83)
                .addComponent(backBtn)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifyBtn)
                    .addComponent(resetBtn))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modifyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyBtnActionPerformed
        // TODO add your handling code here:

        int index = userTable.getSelectedRow();
        String[] userData = userDao.selectRow(index);

        if (userData != null) {  // 아무 값도 선택하지 않았을 때의 예외 처리
            dispose();
            UserModifyScreen userModifyScreen = new UserModifyScreen(userData, index);
            userModifyScreen.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "변경할 사용자 정보를 선택해주세요.");
        }

    }//GEN-LAST:event_modifyBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        dispose();
        ManagementScreen managementScreen = new ManagementScreen();
        managementScreen.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifyBtn;
    private javax.swing.JButton resetBtn;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
