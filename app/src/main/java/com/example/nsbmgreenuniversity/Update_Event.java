package com.example.nsbmgreenuniversity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Update_Event extends AppCompatActivity {

    Button updateBtn,deleteBtn,retriewBtn;
    EditText uid,name,venue,description,date,time;

    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__event);

        firebaseDatabase = FirebaseDatabase.getInstance();
        updateBtn = (Button) findViewById(R.id.button70);
        deleteBtn = (Button) findViewById(R.id.button69);
        retriewBtn = (Button) findViewById(R.id.button68);
        uid = (EditText) findViewById(R.id.editText);
        name = (EditText) findViewById(R.id.editText2);
        venue = (EditText) findViewById(R.id.editText3);
        description = (EditText) findViewById(R.id.editText4);
        date = (EditText) findViewById(R.id.editText5);
        time = (EditText) findViewById(R.id.editText6);

        uid.addTextChangedListener(loginTextWatcher);
        name.addTextChangedListener(loginTextWatcher);
        venue.addTextChangedListener(loginTextWatcher);
        description.addTextChangedListener(loginTextWatcher);
        date.addTextChangedListener(loginTextWatcher);
        time.addTextChangedListener(loginTextWatcher);

        retriewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    DatabaseReference reference = firebaseDatabase.getReference().child("events");
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String userID = uid.getText().toString();
                            if(dataSnapshot.hasChild(userID))
                            {
                                name.setText(dataSnapshot.child(userID).child("name").getValue().toString());
                                venue.setText(dataSnapshot.child(userID).child("venue").getValue().toString());
                                description.setText(dataSnapshot.child(userID).child("description").getValue().toString());
                                date.setText(dataSnapshot.child(userID).child("date").getValue().toString());
                                time.setText(dataSnapshot.child(userID).child("time").getValue().toString());
                            }
                            else
                            {
                                Toast.makeText(Update_Event.this, "Event not found", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                        }
                    });
                }
                catch (Exception e)
                {
                    Log.d("nsbmgreenuniversity", "error : " + e.toString());
                }
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = uid.getText().toString();
                firebaseDatabase.getReference().child("events").child(String.valueOf(userID)).child("name").setValue(name.getText().toString());
                firebaseDatabase.getReference().child("events").child(String.valueOf(userID)).child("venue").setValue(venue.getText().toString());
                firebaseDatabase.getReference().child("events").child(String.valueOf(userID)).child("description").setValue(description.getText().toString());
                firebaseDatabase.getReference().child("events").child(String.valueOf(userID)).child("date").setValue(date.getText().toString());
                firebaseDatabase.getReference().child("events").child(String.valueOf(userID)).child("time").setValue(time.getText().toString());
                Toast.makeText(Update_Event.this, "Event Updated", Toast.LENGTH_SHORT).show();
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseDatabase.getReference().child("events").child(uid.getText().toString()).removeValue();

                Toast.makeText(Update_Event.this, "Event Deleted..", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String nameinput = name.getText().toString().trim();
            String genderinput = venue.getText().toString().trim();
            String positioninput = description.getText().toString().trim();
            String nicinput = date.getText().toString().trim();
            String addressinput = time.getText().toString().trim();

            String uidinput = uid.getText().toString().trim();
            updateBtn.setEnabled(!uidinput.isEmpty());
            deleteBtn.setEnabled(!uidinput.isEmpty());
            retriewBtn.setEnabled(!uidinput.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
