/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cse.projects.hms.view;

import cse.projects.hms.controller.ResCheckController;
import cse.projects.hms.dto.reservation.CustomertableClickcellDto;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 *
 * @author ij944
 */
public class ReservationModifyScreen extends javax.swing.JFrame {

    private CustomertableClickcellDto clickDto = new CustomertableClickcellDto();

    /**
     * Creates new form ReservationModifyScreen
     *
     * @param clickcell
     */
    public ReservationModifyScreen(int calculateDate) {
        initComponents();
        blockCardnumber();
        setLocationRelativeTo(null);
        initializerestriction();
        this.calculate = calculateDate;
    }

    public ReservationModifyScreen(CustomertableClickcellDto clickcell) {
        initComponents();
        blockCardnumber();
        setLocationRelativeTo(null);
        setSelectedcell(clickcell);
        initializerestriction();
    }

    private void initializerestriction() {//객실등급에 따른 인원제한
        if ("Standard".equals(txtroomtype.getText()) || "Royal".equals(txtroomtype.getText())) {
            txtpeople.removeItemAt(4);
            txtpeople.removeItemAt(4);
        }
    }

    private void blockCardnumber() {
        txtpayment.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 아이템 상태가 변경될 때 호출되는 메서드
                blockCardnumber();
                if ("CreditCard".equals(txtpayment.getSelectedItem().toString())) {
                    txtcardnum.setEditable(true);
                } else {
                    txtcardnum.setEditable(false);
                }
            }
        });
    }

    public int calculateDate() {//예상 체크인 날짜와 체크아웃 날짜를 계산하는 메서드
        // 첫번째 JCalendar에서 선택된 날짜 가져오기
        Calendar calendar1SelectedDateCalendar = txtcheckin.getCalendar();
        Date calendar1SelectedDate = calendar1SelectedDateCalendar.getTime();
        LocalDate localDate1 = calendar1SelectedDate.toInstant().atZone(Calendar.getInstance().getTimeZone().toZoneId()).toLocalDate();

        // 첫번째 JCalendar에서 선택된 날짜 가져오기
        Calendar calendar2SelectedDateCalendar = txtcheckout.getCalendar();
        Date calendar2SelectedDate = calendar2SelectedDateCalendar.getTime();
        LocalDate localDate2 = calendar2SelectedDate.toInstant().atZone(Calendar.getInstance().getTimeZone().toZoneId()).toLocalDate();

        // 날짜 차이 계산
        long daysDifference = Math.abs(localDate2.toEpochDay() - localDate1.toEpochDay());
        return (int) daysDifference;
    }

    private void setSelectedcell(CustomertableClickcellDto clickcell) {
        txtname.setText(clickcell.getName());
        txtphone.setText(clickcell.getPhone());
        txtroomtype.setText(clickcell.getRoomtype());
        txtroomnum.setText(clickcell.getRoomnum());
        txtpeople.setSelectedItem(clickcell.getPeople());
        txtmoney.setText(clickcell.getMoney());
        txtpayment.setSelectedItem(clickcell.getPayment());
        txtcardnum.setText(clickcell.getCardnum());

        moneydata = Integer.parseInt(clickcell.getMoney());
        roomnumber = clickcell.getRoomnum();
        people = Integer.parseInt(clickcell.getPeople());
    }
    private String m_name;
    private String m_phone;
    private String m_roomtype;
    private String m_roomnumber;
    private String m_people;
    private String m_checkin;
    private String m_checkout;
    private String m_money;
    private String m_payment;
    private String m_cardnum;
    private String m_roomstate;
            
    private String roomnumber; // 수정전 호수
    private int people; //수정전 인원수
    private int moneydata; //수정전 누적요금
    private int calculate;

    public String getroomnum() {
        String vau = txtroomnum.getText();
        return vau;
    }

    public int modifymoney() {
        int money = 0;
        int difference = people - Integer.parseInt(txtpeople.getSelectedItem().toString());
        if (difference > 0) { //수정 전 인원수가 더 높을 때
            switch (difference) {//인원수에 따른 추가요금 설정
                case 1:
                    money -= 30000;
                    break;
                case 2:
                    money -= 60000;
                    break;
                case 3:
                    money -= 90000;
                    break;
                case 4:
                    money -= 120000;
                    break;
                case 5:
                    money -= 150000;
                    break;
            }
        } else if (difference < 0) { //수정 후 인원수가 더 높을 때
            switch (difference) {//인원수에 따른 추가요금 설정
                case -1:
                    money += 30000;
                    break;
                case -2:
                    money += 60000;
                    break;
                case -3:
                    money += 90000;
                    break;
                case -4:
                    money += 120000;
                    break;
                case -5:
                    money += 150000;
                    break;
            }    //인원수에 따른 추가요금 설정
        } else if (difference == 0) {
            money = 0;
        }
        return money;
    }

    private int calculateDateMoney() {
        int money = 0;
        int difference = calculate - calculateDate();
        if (difference < 0) { //수정 후 날짜 차이가 더 큰 경우
            switch (difference) {
                case -2:
                    money += 50000;
                    break;
                case -3:
                    money += 100000;
                    break;
                case -4:
                    money += 150000;
                    break;
                case -5:
                    money += 200000;
                    break;
            }
        } else if (difference > 0) {//수정 후 날짜 차이가 더 작은 경우
            switch (difference) {
                case 2:
                    money -= 50000;
                    break;
                case 3:
                    money -= 100000;
                    break;
                case 4:
                    money -= 150000;
                    break;
                case 5:
                    money -= 200000;
                    break;
            }
        } else if (difference == 0) {
            money = 0;
        }
        return money;
    }

    private String calculateMoney() {
        int money = moneydata;
        money += modifymoney() + calculateDateMoney();
        return Integer.toString(money);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *
     * @param clickcell
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        txtroomtype = new javax.swing.JTextField();
        txtroomnum = new javax.swing.JTextField();
        BUTT_goback = new javax.swing.JButton();
        BUTT_mofify = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtcardnum = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtmoney = new javax.swing.JTextField();
        txtpayment = new javax.swing.JComboBox<>();
        txtpeople = new javax.swing.JComboBox<>();
        txtcheckin = new com.toedter.calendar.JDateChooser();
        txtcheckout = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel1.setText("예약자:");

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel2.setText("전화번호:");

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel3.setText("객실타입:");

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel4.setText("객실호수:");

        jLabel5.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel5.setText("객실인원:");

        jLabel6.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel6.setText("체크인:");

        jLabel7.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel7.setText("체크아웃:");

        jLabel8.setFont(new java.awt.Font("맑은 고딕", 0, 24)); // NOI18N
        jLabel8.setText("Modify the Reservation");

        txtroomtype.setEditable(false);

        txtroomnum.setEditable(false);

        BUTT_goback.setText("뒤로 가기");
        BUTT_goback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_gobackActionPerformed(evt);
            }
        });

        BUTT_mofify.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        BUTT_mofify.setText("수정");
        BUTT_mofify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTT_mofifyActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel9.setText("결제수단:");

        jLabel10.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel10.setText("카드번호:");

        jLabel11.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel11.setText("누적요금:");

        txtmoney.setEditable(false);

        txtpayment.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        txtpayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CreditCard", "Cash" }));

        txtpeople.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        txtpeople.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));

        jLabel12.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel12.setText("객실상태:");

        jComboBox1.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "empty room", "full room" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(BUTT_goback))
                    .addComponent(BUTT_mofify, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtcheckin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(82, 82, 82))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtroomtype, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtroomnum, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtpeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtpayment, javax.swing.GroupLayout.Alignment.TRAILING, 0, 134, Short.MAX_VALUE)
                                    .addComponent(txtmoney, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtcheckout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtcardnum, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BUTT_goback))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtname)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtcheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtcheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmoney, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtroomtype, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtroomnum, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtpeople, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtcardnum, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(BUTT_mofify, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BUTT_gobackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_gobackActionPerformed
        // TODO add your handling code here:
        ReservationCheckScreen res = new ReservationCheckScreen();
        res.setVisible(true);
        dispose();
    }//GEN-LAST:event_BUTT_gobackActionPerformed

    private void BUTT_mofifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTT_mofifyActionPerformed
        if (txtcheckin.getDate() != null && txtcheckout.getDate() != null) {
            if (calculateDate() <= 5) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                m_name = txtname.getText();
                m_phone = txtphone.getText();
                m_roomtype = txtroomtype.getText();
                m_roomnumber = txtroomnum.getText();
                m_people = txtpeople.getSelectedItem().toString();
                m_checkin = dateFormat.format(txtcheckin.getDate());
                m_checkout = dateFormat.format(txtcheckout.getDate());
                m_money = calculateMoney();
                m_payment = txtpayment.getSelectedItem().toString();
                m_cardnum = txtcardnum.getText();

                m_roomstate = jComboBox1.getSelectedItem().toString();
                
                String modifysell;
                modifysell = m_name + ',' + m_phone + ',' + m_roomtype + ',' + m_roomnumber + ',' + m_people + ',' + m_checkin + ',' + m_checkout + ',' + m_money + ',' + m_payment + ',' + m_cardnum+','+m_roomstate;
                ResCheckController res = new ResCheckController();
                res.modifyUserdata(roomnumber, modifysell);
                JOptionPane.showMessageDialog(null, "예약정보가 성공적으로 수정되었습니다.  "+"결제요금은 "+m_money+" 입니다.");

            } else {
                JOptionPane.showMessageDialog(null, "객실이용제한은 5일입니다.");
            }
        } else
            JOptionPane.showMessageDialog(null, "체크인과 체크아웃 시간을 설정해주세요.");
    }//GEN-LAST:event_BUTT_mofifyActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUTT_goback;
    private javax.swing.JButton BUTT_mofify;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtcardnum;
    private com.toedter.calendar.JDateChooser txtcheckin;
    private com.toedter.calendar.JDateChooser txtcheckout;
    private javax.swing.JTextField txtmoney;
    private javax.swing.JTextField txtname;
    private javax.swing.JComboBox<String> txtpayment;
    private javax.swing.JComboBox<String> txtpeople;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtroomnum;
    private javax.swing.JTextField txtroomtype;
    // End of variables declaration//GEN-END:variables
}
