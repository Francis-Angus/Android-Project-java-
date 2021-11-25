package com.example.project1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, MainActivity2.class); //選擇切換到第二畫面
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) { //回傳接收站
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){ //接收代號1
            if(resultCode == RESULT_OK){ //回傳OK
                Bundle bundle = data.getBundleExtra("drink"); //取得drink的Bundle
                TextView text = findViewById(R.id.textView10);
                text.setText("飲料："+bundle.getString("name")); //bundle的name 飲料名稱

                text = findViewById(R.id.textView11);
                text.setText("冰塊："+bundle.getString("ice")); //bundle的ice 冰塊多寡

                text = findViewById(R.id.textView12);
                text.setText("甜度："+bundle.getString("sweet")); //bundle的sweet 甜度

            }
        }
    }

    public void click_order(View view) {

        startActivityForResult(intent,1); //傳送代號1
    }
}