package com.example.kiba.musicapp2;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Game1Activity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer Song;
    int pause;

    public int a;

    Button check_butt;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);

        RadioButton r1 = (RadioButton)findViewById(R.id.radiobutton1);
        r1.setOnClickListener(radioButtonClickListener);

        RadioButton r2 = (RadioButton)findViewById(R.id.radiobutton2);
        r2.setOnClickListener(radioButtonClickListener);

        RadioButton r3 = (RadioButton)findViewById(R.id.radiobutton3);
        r3.setOnClickListener(radioButtonClickListener);

        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(this);

        check_butt = (Button) findViewById(R.id.check_butt);
        check_butt.setOnClickListener( this);
    }

    public void onClick (View v) {
        switch (v.getId()) {
            case R.id.next:
                Intent intent = new Intent(this, Game2Activity.class);
                intent.putExtra("value", a);
                startActivity(intent);
                Song.stop();
                break;
            case R.id.check_butt:
                AlertDialog.Builder builder = new AlertDialog.Builder(Game1Activity.this);
                builder.setTitle("P.S.Answer")
                        .setMessage("5`nizza - Солдат")
                        .setCancelable(false)
                        .setNegativeButton("ОК",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
                break;
            default:
                break;
        }
    }

    View.OnClickListener radioButtonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            RadioButton rb = (RadioButton) v;
            switch (rb.getId()) {
                case R.id.radiobutton1:
                    a += 0;
                    break;
                case R.id.radiobutton2:
                    a += 0;
                    break;
                case R.id.radiobutton3:
                    a += 1;;
                    break;
                default:
                    break;

            }
        }
    };

    public void play (View viev){
        if (Song == null){
            Song = MediaPlayer.create(this,R.raw.song1);
            Song.start();
        }
        else if(!Song.isPlaying()) {
            Song.seekTo(pause);
            Song.start();
        }
    }
    public void pause (View viev){
            Song.pause();
            pause = Song.getCurrentPosition();
    }
    public void stop (View viev){
            Song.stop();
            Song = null;
    }


    @Override
    public void onBackPressed() {

    }

}
