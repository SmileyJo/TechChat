package com.example.ejmoore.testing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Compose extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(this);

        Button phoneBook = (Button) findViewById(R.id.phonebook);
        phoneBook.setOnClickListener(this);
    }


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.send:
                    //send message to server to be retreived by other person
                    break;

                case R.id.phonebook: //got to phonebook list. for some reason this still does not work.
                    startActivity(new Intent(Compose.this, phoneBook.class));
                    break;

            }
        }


    }

