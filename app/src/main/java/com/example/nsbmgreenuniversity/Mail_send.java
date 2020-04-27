package com.example.nsbmgreenuniversity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Mail_send extends AppCompatActivity {
    EditText eTo;
    Button bSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_send);

        eTo=findViewById(R.id.to);
        bSend=findViewById(R.id.btn);

        bSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validateEmailAddress(eTo);

            }
        });


    }



    private boolean validateEmailAddress(EditText eTo)
    {
        String emailInput=eTo.getText().toString();
        if(!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches() && emailInput.equals("inquiries@nsbm.lk"))
        {
            Toast.makeText( this,"The email address is successfully", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" +eTo.getText().toString()));
            startActivity(intent);
            return  true;
        }
        else if(emailInput.isEmpty())
        {
            Toast.makeText( this,"Please enter the above email address", Toast.LENGTH_SHORT).show();
            return false;
        }

        else if(Patterns.EMAIL_ADDRESS.matcher(emailInput).matches() && !emailInput.equals("inquiries@nsbm.lk"))
        {
            Toast.makeText( this,"You cannot access any other email address.Please enter above email", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches())
        {
            Toast.makeText( this,"Your email address is invalied & enter the above email", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            return false;
        }
    }
}
