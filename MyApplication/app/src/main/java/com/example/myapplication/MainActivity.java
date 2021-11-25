package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/*
示範用Intent來切換畫面，並傳送上一個畫面的訊息到新畫面使用
 */

public class MainActivity extends AppCompatActivity {
    TextView text;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView);

        intent = new Intent(this,MainActivity2.class); //選擇跳躍視窗
        intent.putExtra("key","測試從畫面1傳送到畫面畫2"); //傳送內容至畫面2
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) { //取得回傳內容方法
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
        {
            if(requestCode==1)
            {
                text.setText(data.getStringExtra("key")); //取得回傳內容

            }
        }
    }
    public void clicl1(View view) {
        startActivityForResult(intent,1); //傳送識別數字
    }
}