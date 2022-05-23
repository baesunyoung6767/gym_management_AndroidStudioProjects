package com.example.management;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;

import java.util.ArrayList;

//데이터베이스 관리
public class UserDBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "Member.db";

    public UserDBHelper(@Nullable Context context) { //생성자
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //데이터 베이스가 생성이 될 때 호출

        //데이터베이스 -> 테이블 -> 컬럼 -> 값
        //sql쿼리문 입력
        db.execSQL("CREATE TABLE IF NOT EXISTS Member (memberID TEXT PRIMARY KEY, memberPassword TEXT NOT NULL,memberName TEXT NOT NULL, memberAddress TEXT NOT NULL, " +
                "membership_name TEXT NOT NULL, trainer_Num INTEGER NOT NULL , member_joinDate TEXT NOT NULL, membership_count INTEGER NOT NULL)");
        //테이블이 존재하지 않으면 생성
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        if(!db.isReadOnly()) {
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                String query = String.format ("PRAGMA foreign_keys = %s", "ON");
                db.execSQL(query);
            } else {
                db.setForeignKeyConstraintsEnabled(true);
            }
        }

    }

    //SELECT 조회
    public ArrayList<User> getUser() {
        ArrayList<User> users = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Member",null);
        if(cursor.getCount() != 0) {
            //테이블에 저장된 데이터가 있을 경우 조회
            while(cursor.moveToNext()) {
                String memberID = cursor.getString(cursor.getColumnIndexOrThrow("memberID"));
                String memberPassword = cursor.getString(cursor.getColumnIndexOrThrow("memberPassword"));
                String memberName = cursor.getString(cursor.getColumnIndexOrThrow("memberName"));
                String memberAddress = cursor.getString(cursor.getColumnIndexOrThrow("memberAddress"));
                //String membership_name = cursor.getString(cursor.getColumnIndexOrThrow("membership_name"));
                //int trainer_Num = cursor.getInt(cursor.getColumnIndexOrThrow("trainer_Num"));
               // String member_joinDate = cursor.getString(cursor.getColumnIndexOrThrow("member_joinDate"));
                //int membership_count = cursor.getInt(cursor.getColumnIndexOrThrow("membership_count"));

                User user = new User();

                user.setUserID(memberID);
                user.setUserPassword(memberPassword);
                user.setUserName(memberName);
                user.setUserAddress(memberAddress);
               //user.setMembership_name(membership_name);
                //user.setTrainer_Num(trainer_Num);
                //user.setMember_joinDate(member_joinDate);
               // user.setMembership_count(membership_count);

                users.add(user);
            }
        }
        cursor.close();

        return users;
    }

    //INSERT
    public void Insert(String _memberID, String _memberPassword, String _memberName, String _memberAddress, String _membership_name, int _trainer_Num, String _member_joinDate, int _membership_count) {
        SQLiteDatabase db = getWritableDatabase(); //쓰기가 가능한
        db.execSQL("INSERT INTO Member(memberID, memberPassword, memberName, memberAddress,membership_name,trainer_Num,member_joinDate, membership_count)" +
                " VALUES('" + _memberID + "','" + _memberPassword + "','" + _memberName + "','" + _memberAddress + "','" + _membership_name + "','" + _trainer_Num + "','" + _member_joinDate + "','" + _membership_count + "' );");
    }

    //UPDATE
    public void Update(String _memberID, String _memberPassword, String _memberName, String _memberAddress, String _membership_name, int _trainer_Num, String _member_joinDate, String _membership_count) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE Member SET memberID='" + _memberID + "',memberPassword='" + _memberPassword + "', memberName='" + _memberName + "', memberAddress='" + _memberAddress + "' " +
                " , membership_name='" + _membership_name + "', trainer_Num='" + _trainer_Num + "', member_joinDate='" + _member_joinDate + "', membership_count='" + _membership_count + "' WHERE memberID= '" + _memberID + "' ");
        //where == if문
    }

    //DELETE
    public void delete(String _memberID) {
        SQLiteDatabase db = getWritableDatabase();
        //db.execSQL("DELETE FROM User WHERE id = '" + _id + "' "); //_id에 해당되는 데이터를 삭제한다
        db.execSQL("DELETE FROM Member WHERE memberID = '" + _memberID + "' "); //_id에 해당되는 데이터를 삭제한다
    }

}
