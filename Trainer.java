package com.example.management;

public class Trainer {
    int trainerID;
    String trainer_name;
    String phoneNum;
    String trainer_address;

    public Trainer() {

    }

    public int getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(int trainerID) {
        this.trainerID = trainerID;
    }

    public String getTrainer_name() {
        return trainer_name;
    }

    public void setTrainer_name(String trainer_name) {
        this.trainer_name = trainer_name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getTrainer_address() {
        return trainer_address;
    }

    public void setTrainer_address(String trainer_address) {
        this.trainer_address = trainer_address;
    }
}
