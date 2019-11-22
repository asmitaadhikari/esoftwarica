package com.example.esoftwarica;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnlogin;
    EditText etusername, etpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlogin = findViewById(R.id.login);
        etusername = findViewById(R.id.username);
        etpassword = findViewById(R.id.password);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnlogin();
            }
        });

    }
    public void btnlogin(){
        String user =etusername.getText().toString().trim();
        String pass= etpassword.getText().toString().trim();
        if(user.equals("softwarica")&& pass.equals("coventry"))
        {
            Intent intent=new Intent(this,display_activity.class);
            startActivity(intent);

        }
        else {
            Toast.makeText(this,"Username or Password didn't match",Toast.LENGTH_LONG).show();
        }
    }
}