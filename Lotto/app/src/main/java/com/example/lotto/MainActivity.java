package com.example.lotto;


import android.graphics.Color;
import android.os.Bundle; import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // 1.
    Button button;
    TextView text[] = new TextView[30];

    int textId[] = {R.id.text1, R.id.text2, R.id.text3, R.id.text4, R.id.text5, R.id.text6
            ,R.id.text7, R.id.text8, R.id.text9, R.id.text10, R.id.text11, R.id.text12
            ,R.id.text13, R.id.text14, R.id.text15, R.id.text16, R.id.text17, R.id.text18
            ,R.id.text19, R.id.text20, R.id.text21, R.id.text22, R.id.text23, R.id.text24
            ,R.id.text25, R.id.text26, R.id.text27, R.id.text28, R.id.text29, R.id.text30};

    int colors[] = {Color.BLACK, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.RED
            , Color.rgb(188, 233, 50), Color.rgb(100, 80, 255), Color.rgb(200, 10, 10)};

    // 600회부터 783회까지에서 30회 이상 당첨된 번호
    int recentNums [] = { 2, 4, 6, 7, 8, 10,
            11, 12, 13, 15, 16, 17, 18, 19,
            21, 24, 27,
            31, 33, 34, 36, 37, 38, 39,
            41, 43, 44, 45};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2.
        for( int i=0; i< text.length; i++) {
            text[i] = (TextView) findViewById( textId[i]);
        }

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        selectLotto();
    }

    @Override
    public void onClick(View v) {
        //3.
        selectLotto();
    }

    private void selectLotto(){
        int rnum = 5;
        int [] m = new int[6];
        Random random = new Random();
        boolean chk = false;

        for( int i=0, tnum=0; i < rnum; ){
            m[0] = random.nextInt(45) + 1;
            for( int a=1; a <m.length ; ){
                //m[a] = random.nextInt(45) +1;
                m[a] = (int)(Math.random() * 45 )+1;
                //m[a] = recentNums[ (int)(Math.random() * recentNums.length)];

                chk = false;
                for( int b=0; b < a; b++){
                    if( m[a] == m[b]){
                        chk = true; break;
                    }
                }
                if( !chk) a++;
            }

            // 각 합이 106 ~ 170 사이
            int total = 0;
            for( int j=0; j <  m.length; j++){
                total += m[j];
            }
            if( total < 106 || total >170 ) continue;

            sort(m);

            for( int j=0; j < m.length; j++, tnum++){
                text[tnum].setText( ""+m[j] );
                text[tnum].setTextColor( colors[ (int)(Math.random()* colors.length) ]);
            }

            i++;
        }


    }
    // 정렬하기
    private  void sort( int [] m){

        for( int x=0; x <5; x++){
            for( int y=x+1; y <6; y++){
                if( m[x] > m[y]) {
                    int temp = m[x];
                    m[x] = m[y];
                    m[y] = temp;
                }
            }
        }
    }
}
