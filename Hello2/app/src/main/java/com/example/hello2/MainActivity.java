package com.example.hello2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//public class MainActivity extends AppCompatActivity implements View.OnClickListener{
public class MainActivity extends AppCompatActivity{

    EditText editText;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.ideal);
        button = (Button)findViewById(R.id.button);
        //방법1
//        button.setOnClickListener(this);
        //방법2
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "당신의 이상형은 " + editText.getText() + "입니까?", Toast.LENGTH_SHORT).show();

            }
        });

    }
    //방법1
//    @Override
//    public void onClick(View view) {
//        Toast.makeText(this, "당신의 이상형은 " + editText.getText() + "입니까?", Toast.LENGTH_SHORT).show();
//    }
}