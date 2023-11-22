/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.projects.hms.view;

import cse.projects.hms.controller.PaymentController;
import cse.projects.hms.controller.RoomServiceController;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ij944
 */
public class RoomServiceScreen extends javax.swing.JFrame {

    /**
     * Creates new form RoomServiceScreen
     */
    int sum = 0;
    String result = "";
    String result1 = "";

    public RoomServiceScreen() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        RoomNumber = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ServiceMenu = new javax.swing.JTable();
        BUTT_laterpayment = new javax.swing.JButton();
        BUTT_goback = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        userdata = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        BUTT_ok = new javax.swing.JButton();
        BUTT_cancel = new javax.swing.JButton();
        resultmoney = new javax.swing.JTextField();
        BUTT_enter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        order = new javax.swing.JTable();
        BUTT_allcancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("굴림", 0, 20)); // NOI18N
        jLabel2.setText("객실호수:");

        ServiceMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"콤비네이션 피자", "10000"},
                {"고르곤졸라 피자", "38000"},
                {"해산물 스파게티(토마토,크림)", "43000"},
                {"어린이 돈가스", "36000"},
                {"신선한 샐러드", "31000"},
                {"신선한 계절과일", "39000"},
                {"채소볶음밥", "60000"},
                {"라자냐", "38000"},
                {"전복 한우 차돌박이 짬뽕", "43000"},
                {"트러플 짜장면", "43000"},
                {"동파육", "74000"},
                {"차돌박이 야끼우동", "38000"},
                {"해산물 볶음쌀국수", "38000"},
                {"망고빙수", "76000"},
                {"딸기빙수", "65000"},
                {"오레오크림치즈빙수", "56000"},
                {"순수우유케이크", "76000"},
                {"딸기생크림케이크", "67000"},
                {"망고생크림케이크", "80000"},
                {"콜라, 사이다", "7000"},
                {"생과일주스", "34000"},
                {"생과일 스무디", "12000"},
                {"생과일 스퀴시", "30000"},
                {"페리에", "10000"},
                {"마가리따", "30000"},
                {"미도리샤워", "43000"},
                {"아이러쉬 카밤", "23000"},
                {"블루하와이", "40000"},
                {"피냐콜라다", "34000"},
                {"물", "5000"}
            },
            new String [] {
                "Menu", "Price"
            }
        ));
        ServiceMenu.setMinimumSize(new java.awt.Dimension(30, 272));
        ServiceMenu.setRowHeight(30);
        jScrollPane1.setViewportView(ServiceMenu);

        BUTT_laterpayment.setText("메뉴 추가");
        BUTT_laterpayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_laterpaymentActionPerformed(evt);
            }
        });

        BUTT_goback.setText("뒤로 가기");
        BUTT_goback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_gobackActionPerformed(evt);
            }
        });

        userdata.setColumns(20);
        userdata.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        userdata.setRows(5);
        jScrollPane2.setViewportView(userdata);

        jLabel4.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        jLabel4.setText("<주문표>");

        BUTT_ok.setText("메뉴담기");
        BUTT_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_okActionPerformed(evt);
            }
        });

        BUTT_cancel.setText("메뉴취소");
        BUTT_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_cancelActionPerformed(evt);
            }
        });

        resultmoney.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N

        BUTT_enter.setText("enter");
        BUTT_enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_enterActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel3.setText("고객정보");

        jLabel5.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel5.setText("주문표");

        jLabel6.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel6.setText("가격 :");

        order.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Menu", "Price"
            }
        ));
        jScrollPane3.setViewportView(order);

        BUTT_allcancel.setText("전체 취소");
        BUTT_allcancel.setToolTipText("");
        BUTT_allcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_allcancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BUTT_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BUTT_allcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BUTT_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RoomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BUTT_enter)
                                .addGap(195, 195, 195))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BUTT_goback))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BUTT_laterpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(24, 24, 24)
                                    .addComponent(jLabel1))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(233, 233, 233)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(resultmoney, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel5)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RoomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BUTT_enter)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jLabel4))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(BUTT_goback)
                            .addGap(17, 17, 17)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(6, 6, 6))
                            .addComponent(resultmoney, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(BUTT_laterpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(BUTT_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BUTT_allcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BUTT_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        // TODO add your handling code here:
        RoomServiceController res = new RoomServiceController();
        boolean check = res.checkRoomService(RoomNumber.getText());
        if (check == false) { //예약자 이름과 예약된 객실로 바꿔야 함

            DefaultTableModel Model = (DefaultTableModel) ServiceMenu.getModel();
            DefaultTableModel model = (DefaultTableModel) order.getModel();
            int rowcount = ServiceMenu.getSelectedRow();
            result = Model.getValueAt(rowcount, 0).toString();
            result1 = Model.getValueAt(rowcount, 1).toString();
            Object[] resultArray = {result, result1};
            model.addRow(resultArray);

            sum += Integer.parseInt(ServiceMenu.getValueAt(rowcount, 1).toString()); //룸서비스 취소기능은 cancel버튼 눌렀을 때
            resultmoney.setText("" + sum);
        } else {
            JOptionPane.showMessageDialog(null, "예약된 객실이 아닙니다.");
        }

    }//GEN-LAST:event_BUTT_okActionPerformed

    private void BUTT_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_cancelActionPerformed
        if (order.getSelectedRow() != -1) {
            int rowcount = order.getSelectedRow();
            sum -= Integer.parseInt(order.getValueAt(rowcount, 1).toString());
            resultmoney.setText("" + sum);
            DefaultTableModel model = (DefaultTableModel) order.getModel();
            model.removeRow(order.getSelectedRow());
        } else
            JOptionPane.showMessageDialog(null, "취소할 메뉴를 선택해주세요.");
    }//GEN-LAST:event_BUTT_cancelActionPerformed

    private void BUTT_laterpaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_laterpaymentActionPerformed
        // TODO add your handling code here:
        if (ServiceMenu.getSelectedRow() != -1) {
            PaymentController pay = new PaymentController();

            pay.payLaterRoomservice(RoomNumber.getText(), Integer.toString(sum));

            JOptionPane aa = new JOptionPane();
            aa.showMessageDialog(null, "룸서비스 결제금액이 추가되었습니다.");

        } else

            JOptionPane.showMessageDialog(null, "추가할 메뉴를 선택해주세요.");
    }//GEN-LAST:event_BUTT_laterpaymentActionPerformed

    private void BUTT_enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_enterActionPerformed
        RoomServiceController room = new RoomServiceController();
        if (RoomNumber.getText() != null) {

            if (room.checkRoomService(RoomNumber.getText())) {
                String[] result = room.sendRoomService(RoomNumber.getText());
                String data = "이름 : " + result[0] + " 객실 등급 : " + result[2] + " 객실 호수 : " + result[3];
                userdata.setText(data);
            } else {
                JOptionPane.showMessageDialog(null, "점유중인 객실이 아닙니다.");

            }
        } else
            JOptionPane.showMessageDialog(null, "객실호수를 입력해주세요.");
    }//GEN-LAST:event_BUTT_enterActionPerformed

    private void BUTT_allcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_allcancelActionPerformed
        DefaultTableModel model = (DefaultTableModel) order.getModel();
        model.setRowCount(0);
        sum = 0;
        resultmoney.setText("" + sum);
        JOptionPane.showMessageDialog(null, "주문이 전체 삭제되었습니다");
    }//GEN-LAST:event_BUTT_allcancelActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUTT_allcancel;
    private javax.swing.JButton BUTT_cancel;
    private javax.swing.JButton BUTT_enter;
    private javax.swing.JButton BUTT_goback;
    private javax.swing.JButton BUTT_laterpayment;
    private javax.swing.JButton BUTT_ok;
    private javax.swing.JTextField RoomNumber;
    private javax.swing.JTable ServiceMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable order;
    private javax.swing.JTextField resultmoney;
    private javax.swing.JTextArea userdata;
    // End of variables declaration//GEN-END:variables

}
