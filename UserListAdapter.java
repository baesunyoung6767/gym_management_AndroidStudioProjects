package com.example.management;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class UserListAdapter extends BaseAdapter {
    private Context context;
    private List<User> userList;

    public UserListAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getCount() { //현재 사용자의 개수 반환
        return userList.size();
    } //리스트

    @Override
    public Object getItem(int i) { return userList.get(i); } //특정 사용자 반환

    @Override
    public long getItemId(int i) { return i; }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //하나의 사용자에 대한 뷰를 보여주는 것
        View v = View.inflate(context,R.layout.user, null); //xml에 표기화된 레이아웃들을 메모리에 객체화
        TextView userID = (TextView) v.findViewById(R.id.userID);
        TextView userPassword = (TextView) v.findViewById(R.id.userPassword);
        TextView userName = (TextView) v.findViewById(R.id.userName);
        TextView userAddress = (TextView) v.findViewById(R.id.userAddress);

        userID.setText(userList.get(i).getUserID()); //특정 위치에 있는 유저의 아이디
        userPassword.setText(userList.get(i).getUserPassword());
        userName.setText(userList.get(i).getUserName());
        userAddress.setText(userList.get(i).getUserAddress());

        v.setTag(userList.get(i).getUserID()); //특정 유저의 아이디 값 반환
        return v;
    }
}

/* 어댑터 : 데이터 테이블을 목록 형태로 보여주기 위해 사용되는 것으로
데이터를 다양한 형식의 리스트 형식을 보여주기 위해서
데이터와 리스트 뷰 사이에 존재하는 객체 (데이터와 리스트 뷰 사이의 통신을 위한 다리 역할)
 */
