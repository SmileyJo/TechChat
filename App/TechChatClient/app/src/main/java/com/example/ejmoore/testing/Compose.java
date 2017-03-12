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


public class Compose extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Button send = (Button) findViewById(R.id.send);
        Button phonebook = (Button) findViewById(R.id.phonebook);


        send.setOnClickListener(new View.OnClickListener() {
            @Override

            //two buttons produce two outcomes
            public void onClick(View v) {
                if (v.getId() == R.id.send) { //"send" button is untouched
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
                } else if (v.getId() == R.id.phonebook) { //"contacts" button takes you to a listed phonebook
                    startActivity(new Intent(Compose.this, phoneBook.class));
                }
            }

        });


    }
}
