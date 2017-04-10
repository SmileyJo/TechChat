
package com.example.ejmoore.testing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import static java.lang.Thread.sleep;


public class MainActivity extends Activity implements View.OnClickListener {
    EditText username = null;
    String user = null;

    String StoredUsername = null;
    //String[] StoredUsername = FileInput.readFile("username.txt");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.editUsername);
        //user = username.toString().split(""); //converts the input value into an array of strings
        user = username.getText().toString();

        Button signIn = (Button) findViewById(R.id.signIn);
        signIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //cases are used to identify the seperate jobs of each button

        switch (v.getId()) {
            case R.id.signIn:
                //checks to see if a new username needs to be made. if it does, it makes it.
                if(user != StoredUsername && StoredUsername == null){
                    //FileOutput.writeFile("username.txt", user);
                    Toast.makeText(getApplicationContext(), "Congrats, "+
                            username.getText()+"! Your Username was made. /n " +
                            "Login again to go to home page.", Toast.LENGTH_SHORT).show();
                }
                //logs you in if username matches stored file
                if(user == StoredUsername) {
                    startActivity(new Intent(MainActivity.this, HomePage.class));

                    //otherwise, tells you your password is incorrect
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong username. Try Again", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void getMessages() {
        Thread retrieve = null;

        class login implements Runnable {
            @Override
            public void run() {

                String ip = "10.0.2.2";
                int portNumber = 8888;
                try {
                    Socket clientSocket = new Socket(ip,portNumber);
                    System.out.println("Creating new Socket");

                    DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());
                    DataInputStream dataIn  = new DataInputStream(clientSocket.getInputStream());

                    dataOut.writeBytes("Login:");

                    dataOut.writeBytes("Message Request:chicken"); //Temp Out message
                    String msgData = "";

                    byte[] temp = new byte[1];
                    while (dataIn.read(temp) != -1) {
                        System.out.println("Read in one character");
                        msgData += (char) temp[0];
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        retrieve = new Thread(new login());
        retrieve.start();

    }
}
