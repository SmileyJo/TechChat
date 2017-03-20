package com.example.ejmoore.testing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Compose extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Compose Page Reached");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(this);

        Button phoneBook = (Button) findViewById(R.id.phonebook);
        phoneBook.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send:
                sendMessage();
                break;

            case R.id.phonebook: //got to phonebook list. for some reason this still does not work.
                startActivity(new Intent(Compose.this, phoneBook.class));
                break;

        }
    }

    public void sendMessage() {

            EditText message = (EditText) findViewById(R.id.Message);
            String packet = message.getText().toString();

            MainActivity.user.sendMessage(packet);

            message.setText("");
    }


    }

