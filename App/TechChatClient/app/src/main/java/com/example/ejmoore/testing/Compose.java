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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(this);

        Button phonebook = (Button) findViewById(R.id.phonebook);
        send.setOnClickListener(this);
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

    public void sendMessage(View v) {
            int portNumber = 8889;
            try {
                //System.out.println("Attempting Send");
                Socket clientSocket = new Socket("10.0.2.2",portNumber);
                DataOutputStream send = new DataOutputStream(clientSocket.getOutputStream());
                //BufferedReader recieve = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                //System.out.println("Actually Sending");

                EditText message = (EditText) findViewById(R.id.Message);
                String packet = message.getText().toString();
                packet = "Send message:" + "TestID" + ":" + packet;

                send.writeBytes("");
                //System.out.println(clientSocket.isConnected());
            } catch(Exception e) {
                e.printStackTrace();
            }
    }


    }

