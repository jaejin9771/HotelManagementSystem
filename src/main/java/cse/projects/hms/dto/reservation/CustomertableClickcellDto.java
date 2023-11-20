/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.projects.hms.dto.reservation;

/**
 *
 * @author ij944
 */
public class CustomertableClickcellDto {

    private String name;
    private String phone;
    private String roomtype;
    private String roomnumber;
    private String people;
    private String checkin;
    private String checkout;

    public CustomertableClickcellDto() {

    }

    public CustomertableClickcellDto(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public CustomertableClickcellDto(String name, String phone, String roomtype, String roomnumber, String people, String checkin, String checkout) {
        this.name = name;
        this.phone = phone;
        this.roomtype = roomtype;
        this.roomnumber = roomnumber;
        this.people = people;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public void setRoomnum(String roomnum) {
        this.roomnumber = roomnumber;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getPhone() {
        return phone;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public String getRoomnum() {
        return roomnumber;
    }

    public String getPeople() {
        return people;
    }

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

}
