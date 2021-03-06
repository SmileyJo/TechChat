
/*name: Main Acivity(Login page)
authors: James G, Eric M, Jo T.
purpose:  This page allows the user to log in to their user profile. if your user file does not exist
then it prompts you to create a profile
*/
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
    EditText password = null;
    String user = null;
    String pass = null;
    boolean creating = false;
    boolean logging = false;

    String StoredUsername = null;
    //String[] StoredUsername = FileInput.readFile("username.txt");

    @Override
    protected void onCreate(Bundle savedInstanceState) { //all the fun buttons and inputs you see
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.editUsername);
        password = (EditText)findViewById(R.id.editPassword);
        user = username.getText().toString();

        Button signIn = (Button) findViewById(R.id.signIn);
        Button create = (Button) findViewById(R.id.create);
        signIn.setOnClickListener(this);
        create.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //cases are used to identify the seperate jobs of each button

        switch (v.getId()) {
            case R.id.signIn:

                System.out.println("Running Create User");
                user = username.getText().toString();
                pass = password.getText().toString();
                creating = false;

                login();

                //checks to see if a new username needs to be made. if it does, it makes it.
                if(user != StoredUsername && StoredUsername == null){
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
            case R.id.create:
                System.out.println("Running Create User");
                user = username.getText().toString();
                pass = password.getText().toString();
                creating = true;

                login();

                break;
        }
    }

    public void login() {
        Thread retrieve = null;

        class login implements Runnable { //port connection so the user is added to and retreiving from the server
            @Override
            public void run() {

                String ip = "141.219.226.237";
                int portNumber = 8888;
                try {
                    Socket clientSocket = new Socket(ip,portNumber);
                    System.out.println("Creating new Socket");

                    DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());
                    DataInputStream dataIn  = new DataInputStream(clientSocket.getInputStream());

                    if (creating) { //Create User, email:user:pass
                        System.out.println("Creating");
                        dataOut.writeBytes("Add User:" + "yoloswagerino:" + user + ":" + pass); //test username

                        String back = "";

                        byte[] temp = new byte[1];
                        for (int i = 0; i < 3; i++) {
                            dataIn.read(temp);
                            back += (char) temp[0];
                        }

                        System.out.println("Response:" + back);

                        if (back.equals("ack")) {
                            System.out.println("Successfully created a user"); //lets you know if connection to the server allowed you to make your profile
                        } else {
                            System.out.println("Failed to create a user");
                            return;
                        }

                        try {
                            sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    dataOut.writeBytes("Login:" + user + ":" + pass);

                    String response = "";

                    byte[] temp = new byte[1];
                    for (int i = 0; i < 4; i++) {
                        dataIn.read(temp);
                        if (i == 0) {
                            if (!creating) i++;
                            else continue;
                        }
                        response += (char) temp[0];
                    }

                    System.out.println("Response:" + response);

                    if (response.equals("ack")) {
                        System.out.println("Successfully Logged In");
                        dataOut.writeBytes("Exit");
                        logging = true;
                    } else {
                        System.out.println("Failed to Log In");
                        dataOut.writeBytes("Exit");
                        logging = false;
                        return;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        retrieve = new Thread(new login());
        retrieve.start();

        try {
            retrieve.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (logging) {
            User.setupUser(user,pass);
            startActivity(new Intent(MainActivity.this, HomePage.class)); //takes you to the home page on login
        }
    }
}
