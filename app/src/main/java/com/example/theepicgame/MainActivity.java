package com.example.theepicgame;

import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

import static java.lang.Math.random;

public class MainActivity extends AppCompatActivity {
    private static final int MAGICAL_NUMBER = 10;
    private Button[] buttons;
    private TextView[] texts;
    public static int Score = 0;
    private Button button;
    private TextView text;
    private TextView mines;

    private int random;
    private int minCount = 0;
    Context context;
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttons = new Button[15];

        texts = new TextView[15];

        mines = (TextView) findViewById(R.id.mines);

        moveOn();

        context = this;


    }


    public void bad() {
        --counter;
        if(counter>=0) {
            Toast.makeText(this, "chances : " + counter, Toast.LENGTH_LONG).show();
        }
        if (counter == 0) {
            Intent intent2 = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent2);


        }
    }


    public void moveOn() {
        for (int i = 0; i < 15; i++) {
            button = (Button) findViewById(getResources().getIdentifier("a" + (i + 1), "id",
                    this.getPackageName()));
            buttons[i] = button;

            text = (TextView) findViewById(getResources().getIdentifier("t" + (i + 1), "id",
                    this.getPackageName()));
            texts[i] = text;


            final int random = new Random().nextInt(20) + 1;


            if (random % 2 == 0) {
                buttons[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bad();
                    }
                });
            }

            if (random % 2 != 0) {
                minCount += 1;
                final int finalI = i;



                mines.setText("Mines remaining : " + minCount);
                buttons[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttons[finalI].setVisibility(View.INVISIBLE);

                        int Scoree= Integer.parseInt(texts[finalI].getText().toString());
                        Score+=Scoree;


                        minCount -= 1;

                        if (minCount == 0) {
                            final MediaPlayer mp = MediaPlayer.create(context, R.raw.sound);
                            mp.start();

                            Intent intent3 = new Intent(MainActivity.this, Main3Activity.class);
                            startActivity(intent3);


                        }
                        mines.setText("Mines remaining : " + minCount);

                    }

                });
            }


        }


    }


}