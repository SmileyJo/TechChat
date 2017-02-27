package com.example.ejmoore.testing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* bellow applies on click listeners to individual buttons.
        the class has "implements view.onclicklistener" to accomodate
        multiple buttons.
         */

        Button compose = (Button) findViewById(R.id.compose);
        compose.setOnClickListener(this);

        Button busy = (Button) findViewById(R.id.busy);
        busy.setOnClickListener(this);

        Button settings = (Button) findViewById(R.id.Settings);
        settings.setOnClickListener(this);

    }

    @Override
            public void onClick(View v) {
        //cases are used to identify the seperate jobs of each button

        switch(v.getId()) { //allows the switching of jobs based on id of button

            case R.id.compose:
                startActivity(new Intent(MainActivity.this, Compose.class));
                break;

            case R.id.busy:
                //block incoming messages.
                break;

            case R.id.Settings: //takes you to settings window
                startActivity(new Intent(MainActivity.this, Settings.class));
                break;
        }


    }

}
