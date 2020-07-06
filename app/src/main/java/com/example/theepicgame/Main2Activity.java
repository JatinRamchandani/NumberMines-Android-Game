package com.example.theepicgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.theepicgame.MainActivity;

import org.w3c.dom.Text;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    private static final int MAGICAL_NUMBER =10 ;
    private TextView n1;
    private Button button;
    private TextView textView;
    private String[] qoute;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        n1=(TextView)findViewById(R.id.n1);

        n1.setText("Your Score="+MainActivity.Score);

        button=(Button)findViewById(R.id.butt);
        textView=(TextView)findViewById(R.id.txt);

        qoute=new String[6];
        qoute[0]="You Loose!!";
        qoute[1]="Better luck next Time!!";
        qoute[2]="Try again!!";
        qoute[3]="You Can't Win !!";
        qoute[4]="This is not your cup of tea!!";
        qoute[5]="It's not easy!!";


        final int random = new Random().nextInt(6);

        if(random==0)
        {
            textView.setText(qoute[0]);
        }
        if(random==1)
        {
            textView.setText(qoute[1]);
        }
        if(random==2)
        {
            textView.setText(qoute[2]);
        }
        if(random==3)
        {
            textView.setText(qoute[3]);
        }
        if(random==4)
        {
            textView.setText(qoute[4]);
        }
        if(random==5)
        {
            textView.setText(qoute[5]);
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartApp();
            }
        });

    }

    private void restartApp() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        int mPendingIntentId = MAGICAL_NUMBER;
        PendingIntent mPendingIntent = PendingIntent.getActivity(getApplicationContext(), mPendingIntentId, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager mgr = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
        System.exit(0);
    }
}
