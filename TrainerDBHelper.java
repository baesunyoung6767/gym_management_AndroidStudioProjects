package com.example.management;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

//데이터베이스 관리
public class TrainerDBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "Trainer.db";

    public TrainerDBHelper(@Nullable Context context) { //생성자
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //데이터 베이스가 생성이 될 때 호출

        //데이터베이스 -> 테이블 -> 컬럼 -> 값
        //sql쿼리문 입력
        db.execSQL("CREATE TABLE IF NOT EXISTS Trainer (trainerID INTEGER PRIMARY KEY, trainer_name TEXT NOT NULL,phoneNum TEXT NOT NULL, trainer_address TEXT NOT NULL)");
        //테이블이 존재하지 않으면 생성
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    //SELECT 조회
    public ArrayList<Trainer> getUser() {
        ArrayList<Trainer> trainers = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Trainer",null);
        if(cursor.getCount() != 0) {
            //테이블에 저장된 데이터가 있을 경우 조회
            while(cursor.moveToNext()) {
                int trainerID = cursor.getInt(cursor.getColumnIndexOrThrow("trainerID"));
                String trainer_name = cursor.getString(cursor.getColumnIndexOrThrow("trainer_name"));
                String phoneNum = cursor.getString(cursor.getColumnIndexOrThrow("phoneNum"));
                String trainer_address = cursor.getString(cursor.getColumnIndexOrThrow("trainer_address"));

                Trainer trainer = new Trainer();

                trainer.setTrainerID(trainerID);
                trainer.setTrainer_name(trainer_name);
                trainer.setPhoneNum(phoneNum);
                trainer.setTrainer_address(trainer_address);
                trainers.add(trainer);
            }
        }
        cursor.close();

        return trainers;
    }

    //INSERT
    public void Insert(int _trainerID, String _trainer_name, String _phoneNum, String _trainer_address) {
        SQLiteDatabase db = getWritableDatabase(); //쓰기가 가능한
        db.execSQL("INSERT INTO Trainer(trainerID, trainer_name, phoneNum, trainer_address)" +
                " VALUES('" + _trainerID + "','" + _trainer_name + "','" + _phoneNum + "','" + _trainer_address + "' );");
    }

    //UPDATE
    public void Update(int _trainerID, String _trainer_name, String _phoneNum, String _trainer_address) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE Trainer SET trainerID='" + _trainerID + "',trainer_name='" + _trainer_name + "', phoneNum='" + _phoneNum + "', trainer_address='" + _trainer_address + "' WHERE trainerID= '" + _trainerID + "' ");
        //where == if문
    }

    //DELETE
    public void delete(String _trainerID) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM Trainer WHERE trainerID = '" + _trainerID + "' "); //_id에 해당되는 데이터를 삭제한다
    }
}

