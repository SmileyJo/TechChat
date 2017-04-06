package com.example.ejmoore.testing;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity implements View.OnClickListener {
    EditText email = null;
    EditText username = null;
    EditText password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        email = (EditText)findViewById(R.id.editEmail);
        username = (EditText)findViewById(R.id.editUsername);
        password = (EditText)findViewById(R.id.editPassword);

        Button register = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //cases are used to identify the seperate jobs of each button

        switch (v.getId()) { //allows the switching of jobs based on id of button
            case R.id.register:
                if(true) {
                    //the register intput is valid
                    startActivity(new Intent(Register.this, HomePage.class));
                } else {
                    //the register input is invalid
                    Toast.makeText(getApplicationContext(), "Invalid reigster information.", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }
}
