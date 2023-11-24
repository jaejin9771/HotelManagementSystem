/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.projects.hms.view;

import cse.projects.hms.controller.CheckInController;
import cse.projects.hms.controller.CheckOutController;
import cse.projects.hms.dao.reservation.ResDao;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author ij944
 */
public class CheckOutScreen extends javax.swing.JFrame {

    /**
     * Creates new form CheckOutScreen
     */
    private String name;
    private String phone;
    private String roomnum;
    private String rescheckout;
    private int totalFee; // 총 요금
    private ResDao resDao = new ResDao();
    public CheckOutScreen() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private static boolean isCheckinTimeValid() {
        // 현재 시간 가져오기
        LocalTime currentTime = LocalTime.now();

        // 체크아웃 가능한 시간 범위 설정 (아침 9시부터 24시까지)
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

        jTextField4 = new javax.swing.JTextField();
        BUTT_goback = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtroomnum = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtcheckout = new javax.swing.JTextArea();
        BUTT_payment = new javax.swing.JButton();
        txtmoney = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        BUTT_checkout = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtaddmoney = new javax.swing.JTextField();

        jTextField4.setText("jTextField3");

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

        jLabel3.setFont(new java.awt.Font("굴림", 1, 36)); // NOI18N
        jLabel3.setText("Check Out");

        jLabel5.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        jLabel5.setText("객실호수:");

        txtcheckout.setColumns(20);
        txtcheckout.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        txtcheckout.setRows(5);
        jScrollPane1.setViewportView(txtcheckout);

        BUTT_payment.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        BUTT_payment.setText("결제");
        BUTT_payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_paymentActionPerformed(evt);
            }
        });

        txtmoney.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel10.setText("총 결제금액:");

        BUTT_checkout.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        BUTT_checkout.setText("check-out");
        BUTT_checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_checkoutActionPerformed(evt);
            }
        });

        jLabel4.setText("*010-0000-0000");

        jLabel11.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel11.setText("시간초과요금:");

        txtaddmoney.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BUTT_payment)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(BUTT_checkout, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(87, 87, 87))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtroomnum, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel10))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtmoney, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                            .addComponent(txtaddmoney))))))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(222, 222, 222)
                        .addComponent(BUTT_goback)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(BUTT_goback))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtroomnum, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(28, 28, 28)
                        .addComponent(BUTT_checkout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmoney, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtaddmoney, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(BUTT_payment, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BUTT_gobackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_gobackActionPerformed
        // TODO add your handling code here:
        MainScreen mainscreen = new MainScreen();
        mainscreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_BUTT_gobackActionPerformed

    private void BUTT_paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_paymentActionPerformed
        CheckOutController check = new CheckOutController(name, phone, roomnum,totalFee);
        // 합산된 총 요금(totalFee) 다른 파일에 저장하는 로직 구현 해아함.
        if (check.deleteData()) {
            JOptionPane.showMessageDialog(null, "결제되었습니다.");
            MainScreen mainscreen = new MainScreen();
            mainscreen.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_BUTT_paymentActionPerformed

    private void BUTT_checkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_checkoutActionPerformed
        name = txtname.getText();
        phone = txtphone.getText();
        roomnum = txtroomnum.getText();
        
        CheckOutController check = new CheckOutController(name, phone, roomnum,totalFee);
        CheckInController Check = new CheckInController(name, phone, roomnum);
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatedNow = now.format(formatter);
        if (!"".equals(txtname.getText()) && !"".equals(txtphone.getText()) & !"".equals(txtroomnum.getText())) {
            if (isCheckinTimeValid()) {
                if (Check.checkFullroom() == false) {
                    if (check.sendCheckoutData() != null) {
                        String[] result = check.sendCheckoutData();
                        rescheckout = result[6];
                        CheckOutController over = new CheckOutController(rescheckout, formatedNow);
                        txtcheckout.append("예상 체크인 날짜: " + result[5] + "\n");
                        txtcheckout.append("예상 체크아웃 날짜: " + result[6] + "\n");
                        txtcheckout.append("현재 체크아웃 날짜: " + formatedNow + "\n");
                        txtcheckout.append("객실타입: " + result[2] + "\n");
                        txtcheckout.append("객실인원: " + result[4] + "\n");
                        txtcheckout.append("결제수단: " + result[8] + "\n");
                        txtcheckout.append("카드번호: " + result[9] + "\n");
                        txtmoney.setText(result[7]);
                        txtaddmoney.setText(over.calculateMoney(over.calculateDate()));
                        totalFee = Integer.parseInt(result[11]) + Integer.parseInt(txtaddmoney.getText());
                        resDao.insertReceipt(result[5], result[6], Integer.toString(totalFee));
                    } else {
                        JOptionPane.showMessageDialog(null, "입력하신 예약 정보가 일치하지 않습니다.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "예약된 정보가 체크인이 되어있지 않습니다.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "체크아웃 시간이 마감되었습니다.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "예약정보를 모두 입력해주세요.");
        }
    }//GEN-LAST:event_BUTT_checkoutActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUTT_checkout;
    private javax.swing.JButton BUTT_goback;
    private javax.swing.JButton BUTT_payment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField txtaddmoney;
    private javax.swing.JTextArea txtcheckout;
    private javax.swing.JTextField txtmoney;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtroomnum;
    // End of variables declaration//GEN-END:variables
}
