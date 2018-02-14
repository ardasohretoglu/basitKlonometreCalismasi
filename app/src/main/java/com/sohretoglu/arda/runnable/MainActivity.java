package com.sohretoglu.arda.runnable;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    int sayac;
    Handler handler;
    Runnable run;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void baslat (View view)
    {
        textView = (TextView) findViewById(R.id.textView);
        sayac=0;
        handler = new Handler();
        run = new Runnable() {
            @Override
            public void run() {

                textView.setText("Zaman : "+sayac);
                sayac++;
                textView.setText("Zaman : "+sayac);
                handler.postDelayed(this,1000);
            }
        };
        handler.post(run);



    }
    public void bitir (View bitir)
    {
        handler.removeCallbacks(run);
        sayac = 0;
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Zaman : "+sayac);

    }
}
