package com.example.hello;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onBtnClick(View v){
        Toast.makeText(this, "확인버튼이 눌림", Toast.LENGTH_LONG).show();
    }

    // Intent : 다른 앱으로 데이터 전송
    public void onNaverClick(View v){
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(myIntent); // Helloapp에서
    }

    // Intent : 다른 앱으로 데이터 전송
    public void onCallClick(View v){
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel://010-3303-1995"));
        startActivity(myIntent);
    }
}