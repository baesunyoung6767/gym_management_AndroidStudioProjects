package com.example.management;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public UserDao mUserDao;

    public static Context context;

    public ListView listView;
    public UserListAdapter adapter;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //화면에 나타낼 뷰 지정
        context = this;

        listView = (ListView) findViewById(R.id.listView);
        userList = new ArrayList<User>(); //초기화

        UserDatabase db = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "user_db")
                .fallbackToDestructiveMigration() //스키마 버전 변경 가능
                .allowMainThreadQueries() //MainThread에서 db IO 가능
                .build(); //데이터베이스 객체 생성

        mUserDao = db.userdao(); //인터페이스 객체 할당

        userList = mUserDao.getAll();
        adapter = new UserListAdapter(getApplicationContext(), userList);
        listView.setAdapter(adapter);

        findViewById(R.id.User_reg_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegistrationUser.class);
                startActivity(intent);
            }
        });
    }
}