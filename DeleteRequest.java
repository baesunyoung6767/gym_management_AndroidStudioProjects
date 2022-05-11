package com.example.management;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.List;

public class DeleteRequest extends AppCompatActivity {
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);

        findViewById(R.id.deleteButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* userList =  ((MainActivity)MainActivity.context).mUserDao.getAll();
                ((MainActivity)MainActivity.context).adapter = new UserListAdapter(getApplicationContext(), userList);
                Object user = ((MainActivity)MainActivity.context).adapter.getItem(1);
                ((MainActivity)MainActivity.context).mUserDao.delete((User)user);
                finish(); */

                //int count, checked ;
                //count = ((MainActivity)MainActivity.context).adapter.getCount() ;

                //if (count > 0) {
                    // 현재 선택된 아이템의 position 획득.
                    /* checked = ((MainActivity)MainActivity.context).listview.getCheckedItemPosition();

                    if (checked > -1 && checked < count) {
                        // 아이템 삭제
                        items.remove(checked) ;

                        // listview 선택 초기화.
                        listview.clearChoices();

                        // listview 갱신.
                        adapter.notifyDataSetChanged(); */

            }
        });
    }
}