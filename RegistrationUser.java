package com.example.management;

//import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class RegistrationUser extends AppCompatActivity {
    private EditText userIDEditText;
    private EditText userPasswordEditText;
    private EditText userNameEditText;
    private EditText userAddressEditText;

    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registration); //화면에 나타낼 뷰 지정

        userIDEditText = findViewById(R.id.userIDInput);
        userPasswordEditText = findViewById(R.id.userPasswordInput);
        userNameEditText = findViewById(R.id.userNameInput);
        userAddressEditText = findViewById(R.id.userAddressInput);

        findViewById(R.id.UserInputCancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.UserInputButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(userIDEditText.getText().toString(),userPasswordEditText.getText().toString(),
                        userNameEditText.getText().toString(),userAddressEditText.getText().toString()); //객체 인스턴스 생성
                ((MainActivity)MainActivity.context).mUserDao.insert(user); //데이터베이스에 삽입

                userList =  ((MainActivity)MainActivity.context).mUserDao.getAll();
                ((MainActivity)MainActivity.context).adapter = new UserListAdapter(getApplicationContext(), userList);
                ((MainActivity)MainActivity.context).listView.setAdapter(((MainActivity)MainActivity.context).adapter);

                finish();
            }
        });

    }
}
