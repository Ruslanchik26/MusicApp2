package com.example.kiba.musicapp2;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button st_b;
    Button h_b;
    Button ab_b;
    Button auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        st_b = (Button) findViewById(R.id.st_b);
        st_b.setOnClickListener( this);

        auth = (Button) findViewById(R.id.auth);
        auth.setOnClickListener(this);

        h_b = (Button) findViewById(R.id.h_b);
        h_b.setOnClickListener(this);

        ab_b = (Button) findViewById(R.id.ab_b);
        ab_b.setOnClickListener(this);
            }

    public void onClick (View v){
        switch (v.getId()){
            case R.id.st_b:
                Intent intent = new Intent(this,Game1Activity.class);
                startActivity(intent);
                break;
            case R.id.auth:
                intent = new Intent(this, LogActivity.class);
                startActivity(intent);
                break;
            case R.id.h_b:
                intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.ab_b:
                intent = new Intent(this, Main3Activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
