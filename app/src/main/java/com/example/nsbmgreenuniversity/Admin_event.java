package com.example.nsbmgreenuniversity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Admin_event extends AppCompatActivity {
    Button addUserBtn,clear;
    TextView useridShow;
    EditText name, venue, description, time, date;
    private int userId = 0;

    FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_event);

        firebaseDatabase = FirebaseDatabase.getInstance();
//        firebaseDatabase.getReference().child("events").child(""+1).child("uid").setValue(1);
//        firebaseDatabase.getReference().child("events").child(""+1).child("name").setValue("nimal");

        addUserBtn = (Button) findViewById(R.id.addnotes);
        useridShow = (TextView) findViewById(R.id.textView54);
        name = (EditText) findViewById(R.id.name);
        venue = (EditText) findViewById(R.id.venue);
        description = (EditText) findViewById(R.id.description);
        time = (EditText) findViewById(R.id.time);
        date = (EditText) findViewById(R.id.date);
        clear = (Button) findViewById(R.id.button64);

        name.addTextChangedListener(loginTextWatcher);
        venue.addTextChangedListener(loginTextWatcher);
        description.addTextChangedListener(loginTextWatcher);
        time.addTextChangedListener(loginTextWatcher);
        date.addTextChangedListener(loginTextWatcher);


        buildUserId();

        addUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseDatabase.getReference().child("events").child(String.valueOf(userId)).child("uid").setValue(userId);
                firebaseDatabase.getReference().child("events").child(String.valueOf(userId)).child("name").setValue(name.getText().toString());
                firebaseDatabase.getReference().child("events").child(String.valueOf(userId)).child("venue").setValue(venue.getText().toString());
                firebaseDatabase.getReference().child("events").child(String.valueOf(userId)).child("description").setValue(description.getText().toString());
                firebaseDatabase.getReference().child("events").child(String.valueOf(userId)).child("date").setValue(date.getText().toString());
                firebaseDatabase.getReference().child("events").child(String.valueOf(userId)).child("time").setValue(time.getText().toString());

                Toast.makeText(Admin_event.this, "New event Added", Toast.LENGTH_SHORT).show();

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                venue.setText("");
                description.setText("");
                date.setText("");
                time.setText("");
            }
        });

    }
    private void buildUserId(){
        firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference reference = firebaseDatabase.getReference().child("events");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int j;
                for (j = 1; dataSnapshot.hasChild(String.valueOf(j)); j++) { }
                userId = j;
                Log.d("nsbmgreenuniversity", "userId..... : " + userId);
                useridShow.setText("Event Id: "+userId);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String emailinput = name.getText().toString().trim();
            String passinput = venue.getText().toString().trim();
            String nameinput = description.getText().toString().trim();
            String nicinput = time.getText().toString().trim();
            String genderinput = date.getText().toString().trim();

            addUserBtn.setEnabled(!emailinput.isEmpty() && !passinput.isEmpty() && !nameinput.isEmpty() && !nicinput.isEmpty() && !genderinput.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
