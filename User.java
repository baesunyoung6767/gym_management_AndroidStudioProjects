package com.example.management;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User { //하나의 사용자 정보 저장
    @PrimaryKey(autoGenerate = true)
    private int id = 0;
    String userID;
    String userPassword;
    String userName;
    String userAddress;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

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

    public User(String userID, String userPassword, String userName, String userAddress) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userAddress = userAddress;
    }
}
