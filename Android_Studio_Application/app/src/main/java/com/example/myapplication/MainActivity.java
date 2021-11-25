package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    TextView views;
    RadioGroup group;
    int shows = -1; //我方猜拳
    String[] guess = {"剪刀", "石頭", "布"} ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = (EditText) findViewById(R.id.edittext); //輸入名子
        views = (TextView) findViewById(R.id.textView2); //顯示勝利
        group = findViewById(R.id.group);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getCheckedRadioButtonId()){ //取得RadioButton id
                    case R.id.radioButton2: //判斷
                        shows = 0;
                    break;
                    case R.id.radioButton3:
                        shows = 1;
                    break;
                    case R.id.radioButton4:
                        shows = 2;
                    break;
                    default:
                        shows = -1;
                }
            }
        });
    }
    public void clickbutton(View view) {
        if(shows == -1){
            views.setText("請猜拳");
            return;
        }
        if(edit.getText().toString().equals("")){
            views.setText("請輸入名子");
            return;
        }
        int fix =(int)(Math.random()*3); //敵方出拳 亂數
        String vietory=""; //儲存勝利

        TextView text = findViewById(R.id.textView7);
        EditText text2 = findViewById(R.id.edittext);

        text.setText(text2.getText()); //名子

        text = findViewById(R.id.textView9); //我方
        text.setText(guess[shows]);

        text = findViewById(R.id.textView10); //敵方
        text.setText(guess[fix]);

        if(shows == fix){ vietory="雙方平手";} //剪刀0 石頭1 布2
        else if(shows == 0 && fix == 1){vietory="敵方勝利";}
        else if(shows == 0 && fix == 2){vietory="我方勝利";}
        else if(shows == 1 && fix == 0){vietory="我方勝利";}
        else if(shows == 1 && fix == 2){vietory="敵方勝利";}
        else if(shows == 2 && fix == 0){vietory="敵方勝利";}
        else if(shows == 2 && fix == 1){vietory="我方勝利";}

        views.setText(vietory); //顯示勝負
        text = findViewById(R.id.textView8); //勝負
        text.setText(vietory); //顯示勝負
    }
}