package com.producer.kafka.dto;

public class Contact {
    private int id;
    private String firstname;
    private String lastname;
    private String address;
    private String phone;
    private String birthDay;
    private String loginDate;


    public Contact() {
        // I have added this because: include a public default constructor.
        //But not sure
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

//    public String getLogin() {
//        return login;
//    }
//    public void setLogin(String login) {
//        this.login = login;
//    }

    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDay=" + birthDay + '\'' +
                ", loginDate='" + loginDate + '\'' +
                '}';
    }
}
