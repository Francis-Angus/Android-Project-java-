package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity2 extends AppCompatActivity {

    Intent intent = new Intent();
    RadioGroup group,group1;
    String ice;
    String sweet;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text = findViewById(R.id.editText); //飲料輸入
        group = findViewById(R.id.radiogroup); //冰塊選擇
        group1 = findViewById(R.id.radiogroup1); //甜度選擇
        ice="";
        sweet="";

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
         {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) { //判斷冰塊選擇RadioButton
                switch (group.getCheckedRadioButtonId()){
                    case R.id.radioButton:
                        ice = "去冰";
                        break;
                    case R.id.radioButton1:
                        ice = "少冰";
                        break;
                    case R.id.radioButton2:
                        ice="多冰";
                        break;
                }
            }
        });
        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { //判斷甜度選擇RadioButton
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getCheckedRadioButtonId()){
                    case R.id.radioButton4:
                        sweet = "少糖";
                        break;
                    case R.id.radioButton5:
                        sweet = "半糖";
                        break;
                    case R.id.radioButton6:
                        sweet="全糖";
                        break;
                }
            }
        });
    }
    public void click_send(View view) {
        Bundle bundle = new Bundle(); //使用Bundle來傳送多筆資料
        bundle.putString("name", String.valueOf(text.getText())); //傳送飲料名稱
        bundle.putString("ice", ice); //傳送冰塊
        bundle.putString("sweet", sweet); //傳送甜度

        intent.putExtra("drink",bundle); //回傳代號
        setResult(RESULT_OK,intent); //回傳
        finish();
    }
}