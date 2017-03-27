package com.example.ejmoore.testing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginOrRegister = (Button) findViewById(R.id.loginOrRegister);
        loginOrRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //cases are used to identify the seperate jobs of each button

        switch (v.getId()) { //allows the switching of jobs based on id of button
            case R.id.loginOrRegister:
                startActivity(new Intent(MainActivity.this, HomePage.class));
                break;
        }
    }
}
