package com.example.kiba.musicapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedBackActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference myRef;
    FirebaseUser user = mAuth.getInstance().getCurrentUser();
    private EditText input;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        myRef = FirebaseDatabase.getInstance().getReference();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        input = (EditText) findViewById(R.id.editText);
        send = (Button) findViewById(R.id.submitSuggestion);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child( user.getUid()).child("Feedback"). push().
                        setValue(input.getText().toString());
                Toast.makeText(FeedBackActivity.this, "Sent", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FeedBackActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }





}
