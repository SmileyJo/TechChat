package com.example.ejmoore.testing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OptionalDataException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;


public class Compose extends Activity implements View.OnClickListener {

    private ArrayList<String> input_messages = new ArrayList<String>();
    String[] testMessages = {""};
    private ArrayAdapter<String> adapter;
    EditText type1 = null;  //these are made global variables for the purpose of calling them in multiple methods
    String packet = "";
    ListView messagelist;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Compose Page Reached");

        setTitle(User.convoUser);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);

        Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(this);

//        Button phoneBook = (Button) findViewById(R.id.phonebook);
//        phoneBook.setOnClickListener(this);

        type1 = (EditText) findViewById(R.id.type);  //sets the global variables
        packet = type1.getText().toString();

        messagelist = (ListView) findViewById(R.id.messages);  //establishes the list veiw

        System.out.println("after listview but before arrayadapter");
        //indicates the list veiw can pull from the arraylist input_messages
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, testMessages);
        messagelist.setAdapter(adapter);

        getMessages();

    }

    public void getMessages() {
        Thread retrieve = null;

        class get implements Runnable {
            @Override
            public void run() {
                ArrayList<String> messages = new ArrayList<String>();

                String ip = "141.219.247.142";
                int portNumber = 8888;
                try {
                    Socket clientSocket = new Socket(ip,portNumber);
                    System.out.println("Creating new Socket");

                    DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());
                    DataInputStream  dataIn  = new DataInputStream(clientSocket.getInputStream());

                    dataOut.writeBytes("Login:" + User.user + ":" + User.password);

                    dataOut.writeBytes("Message Request:" + User.convoUser); //Temp Out message
                    String msgData = "";

                    byte[] temp = new byte[1];
                    while (dataIn.read(temp) != -1) {
                        System.out.println("Read in one character");
                        msgData += (char) temp[0];
                    }
                    System.out.println("Managed to exit loop");
                    System.out.println(msgData);
                    System.out.println("Data Recieved");
                    String[] tempMessages = msgData.split("\n");

                    messages.clear();

                    for (int i = 0; i < tempMessages.length; i++) {
                        if (tempMessages[i].contains(":"))
                            if (tempMessages[i].split(":").length < 3){
                                messages.add("");
                            } else
                                messages.add(tempMessages[i].split(":")[2]);
                    }

                    clientSocket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                //displayMessage();
                testMessages = new String[messages.size()];
                int i = 0;
                for (String s : messages) {
                    testMessages[i++] = s;
                }

            }
        }

        retrieve = new Thread(new get());
        retrieve.start();

        try {
            retrieve.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        displayMessage();
    }

    //adds the string to the input message and notifies the array adapter for list of change.
    public void displayMessage(){
        //input_messages.add(string);
        //testMessages[2] = string;

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, testMessages);
        messagelist.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send:
                System.out.println("start send");
                //puts message from textbox into top or bottom of list veiw
                //EditText message = (EditText) findViewById(R.id.type);
                //String packet = message.getText().toString();
                //displayMessage(packet);

                //sends message encased in text box.
                sendMessage();
                //getMessages();

                break;

            case R.id.phonebook: //got to phonebook list. for some reason this still does not work.
                startActivity(new Intent(Compose.this, phoneBook.class));
                break;
        }

        //any incoming messages are automatically put into list view in order of received
        //alongside messages input from "send" button
    }

    public void sendMessage() {
        EditText message = (EditText) findViewById(R.id.type);

        class sendThread implements Runnable {

            @Override
            public void run() {
                EditText message = (EditText) findViewById(R.id.type);
                String packet = message.getText().toString();

                if (packet.equals("")) {
                    return;
                }

                String ip = "141.219.247.142";
                int portNumber = 8888;
                try {
                    Socket clientSocket = new Socket(ip,portNumber);
                    System.out.println("Creating new Socket");
                    DataOutputStream send = new DataOutputStream(clientSocket.getOutputStream());

                    send.writeBytes("Login:" + User.user + ":" + User.password);

                    packet = "Send Message:" + User.user + ":" + User.convoUser + ":" + packet;
                    System.out.println("Sending: " + packet);
                    send.writeBytes(packet);

                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Thread send = null;
        send = new Thread(new sendThread());
        send.start();

        try {
            send.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        message.setText("");

        type1.setText("");

        getMessages();
    }



}





