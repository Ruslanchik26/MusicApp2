package com.example.kiba.musicapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class End5Activity extends AppCompatActivity implements View.OnClickListener {
    int a;
    Button end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end5);

        Intent intent = getIntent();
        a = intent.getIntExtra("value", 0);

        TextView myText = (TextView) findViewById(R.id.txtA);
        myText.setText("Yahoo! You guess " + a + "of 3 songs!");

        end = (Button) findViewById(R.id.end);
        end.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id. end:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
        }
    }
    @Override
    public void onBackPressed() {
    }

}
