package com.example.ejmoore.testing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Compose extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        Button send = (Button) findViewById(R.id.send);
        Button phonebook = (Button) findViewById(R.id.phonebook);

        send.setOnClickListener(new View.OnClickListener() {
            @Override

            //two buttons produce two outcomes
            public void onClick(View v) {
                if (v.getId() == R.id.send) { //"send" button is untouched

                } else if (v.getId() == R.id.phonebook) { //"contacts" button takes you to a listed phonebook
                    startActivity(new Intent(Compose.this, phoneBook.class));
                }
            }

        });


    }
}
