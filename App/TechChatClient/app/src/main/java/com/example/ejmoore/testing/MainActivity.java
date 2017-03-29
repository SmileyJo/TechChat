package com.example.ejmoore.testing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {
    EditText username = null;
    EditText password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.editUsername);
        password = (EditText)findViewById(R.id.editPassword);

        Button loginOrRegister = (Button) findViewById(R.id.loginOrRegister);
        loginOrRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //cases are used to identify the seperate jobs of each button

        switch (v.getId()) { //allows the switching of jobs based on id of button
            case R.id.loginOrRegister:
                if(username.getText().toString().equals("username") &&
                        password.getText().toString().equals("password")) {
                    startActivity(new Intent(MainActivity.this, HomePage.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong username or password. try 'username' and 'password'", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
