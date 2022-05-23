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
    private EditText membership_NameEditText;
    private EditText trainerNumEditText;
    private EditText membership_joinDateEditText;
    private EditText membership_countEditText;

    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registration); //화면에 나타낼 뷰 지정

        userIDEditText = findViewById(R.id.userIDInput);
        userPasswordEditText = findViewById(R.id.userPasswordInput);
        userNameEditText = findViewById(R.id.userNameInput);
        userAddressEditText = findViewById(R.id.userAddressInput);
        membership_NameEditText = findViewById(R.id.membership_NameInput);
        trainerNumEditText = findViewById(R.id.trainerNumInput);
        membership_joinDateEditText = findViewById(R.id.member_joinDateInput);
        membership_countEditText = findViewById(R.id.membership_CountInput);

        findViewById(R.id.UserInputCancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.UserInputButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int trainerNum = Integer.parseInt(trainerNumEditText.getText().toString());
                int membershipCount = Integer.parseInt(membership_countEditText.getText().toString());

                ((MainActivity)MainActivity.context).mUserDBHelper.Insert(userIDEditText.getText().toString(), userPasswordEditText.getText().toString(),
                        userNameEditText.getText().toString(),userAddressEditText.getText().toString(),membership_NameEditText.getText().toString(),
                        trainerNum, membership_joinDateEditText.getText().toString(), membershipCount);

                userList = ((MainActivity)MainActivity.context).mUserDBHelper.getUser();
                ((MainActivity)MainActivity.context).adapter = new UserListAdapter(getApplicationContext(), userList);
                ((MainActivity)MainActivity.context).listView.setAdapter(((MainActivity)MainActivity.context).adapter);

                finish();
            }
        });

    }
}
