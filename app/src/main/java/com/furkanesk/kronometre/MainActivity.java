package com.furkanesk.kronometre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text1;
    TextView text2;
    Button button;
    Button button2;
    Handler handler;
    Runnable runnable;
    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        number = 0;
        button2.setEnabled(false);

    }
    public void start(View view){
        button2.setEnabled(true);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                text1.setText("Time: "+ number);
                number++;
                text1.setText("Time: "+ number);
                handler.postDelayed(runnable,1000);
            }
        };
        handler.post(runnable);
        button.setEnabled(false);

    }
    public void stop(View view){
        button2.setEnabled(false);
        button.setEnabled(true);
        handler.removeCallbacks(runnable);
        text2.setText("Time saved: "+number);
        number = 0;
        text1.setText("Time: "+number);
    }
}
