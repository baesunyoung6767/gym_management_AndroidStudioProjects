package com.example.management;

public class User { //하나의 사용자 정보 저장
    //private int id;
    String userID;
    String userPassword;
    String userName;
    String userAddress;
    String membership_name;
    int trainer_Num;
    String member_joinDate;
    int membership_count;

    public User() {

    }

    public String getMembership_name() {
        return membership_name;
    }

    public void setMembership_name(String membership_name) {
        this.membership_name = membership_name;
    }

    public int getTrainer_Num() {
        return trainer_Num;
    }

    public void setTrainer_Num(int trainer_Num) {
        this.trainer_Num = trainer_Num;
    }

    public String getMember_joinDate() {
        return member_joinDate;
    }

    public void setMember_joinDate(String member_joinDate) {
        this.member_joinDate = member_joinDate;
    }

    public int getMembership_count() {
        return membership_count;
    }

    public void setMembership_count(int membership_count) {
        this.membership_count = membership_count;
    }

    //public int getId() { return id; }

    //public void setId(int id) { this.id = id; }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

}
