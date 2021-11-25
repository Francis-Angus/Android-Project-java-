package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView text = findViewById(R.id.textView2);
        text.setText(getIntent().getStringExtra("key")); //取得回傳內容
    }

    public void click2(View view) {
        Intent intent = new Intent();
        intent.putExtra("key","測試從畫面2傳送到畫面1"); //傳送容置畫面1

        setResult(RESULT_OK,intent); //回傳intent
        finish(); //直接結束而不是跳轉到畫面1


    }
}