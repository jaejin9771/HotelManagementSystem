/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.projects.hms.dto.reservation;

/**
 *
 * @author 재진
 */
public class ResDto {

    private String name; // 이름
    private String phonenumber; // 전화번호
    private String roomtype; // 객실 등급
    private String roomnum; // 객실 번호
    private String peoplenum; // 인원 수
    private String checkin; // 체크인 시간
    private String checkout; // 체크아웃 시간
    private String money;
    private String selectedpayment;
    private String cardnumbers;
    private String occupation;
    private String totalFee;
    //private String userdata; //유저정보모음

    @Override
    public String toString() {
        return name + ',' + phonenumber + ',' + roomtype + ',' + roomnum + ',' + peoplenum + ',' + checkin + ',' + checkout + ','+ money + ',' + selectedpayment + ',' + cardnumbers+','+occupation+ ',' + totalFee;
    }

    public ResDto(String name, String phonenumber, String roomtype, String roomnum, String peoplenum, String checkin, String checkout,String selectedpayment,String cardnumbers, String money,String occupation,String totalFee) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.roomtype = roomtype;
        this.roomnum = roomnum;
        this.peoplenum = peoplenum;
        this.checkin = checkin;
        this.checkout = checkout;
        this.selectedpayment=selectedpayment;
        this.cardnumbers=cardnumbers;
        this.money = money; // 현재 요금
        this.occupation=occupation;
        this.totalFee = totalFee; // 총 요금
        //this.userdata = name +',' + phonenumber + ','+roomtype+','+ roomnum+','+peoplenum+','+checkin+','+checkout+'\n';
    }
//    public String getUserdata() {
//        return userdata;
//    }

    public String getMoney() {
        return money;
    }

    public String getSelectedpayment() {
        return selectedpayment;
    }

    public void setSelectedpayment(String selectedpayment) {
        this.selectedpayment = selectedpayment;
    }

    public String getCardnumbers() {
        return cardnumbers;
    }

    public void setCardnumbers(String cardnumbers) {
        this.cardnumbers = cardnumbers;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

    public String getPeoplenum() {
        return peoplenum;
    }

    public void setPeoplenum(String peoplenum) {
        this.peoplenum = peoplenum;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }
    
}
