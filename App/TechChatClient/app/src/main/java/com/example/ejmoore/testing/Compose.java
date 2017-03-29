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


public class Compose extends Activity implements View.OnClickListener {

    private ArrayList<String> input_messages = new ArrayList<String>();
    String[] testMessages = {"Test1","Test2","Test3"};
    private ArrayAdapter<String> adapter;
    EditText type1 = null;  //these are made global variables for the purpose of calling them in multiple methods
    String packet = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Compose Page Reached");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);

        Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(this);

        Button phoneBook = (Button) findViewById(R.id.phonebook);
        phoneBook.setOnClickListener(this);

        EditText user = (EditText) findViewById(R.id.username);

        type1 = (EditText) findViewById(R.id.type);  //sets the global variables
        packet = type1.getText().toString();

        ListView messagelist = (ListView) findViewById(R.id.messages);  //establishes the list veiw

        System.out.println("after listview but before arrayadapter");
        //indicates the list veiw can pull from the arraylist input_messages
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, testMessages);
        messagelist.setAdapter(adapter);


//          Thread connectThread = new Thread(new Runnable() { //is supposed to connect to the server.
//              public void run() {
//                  serverConnect = new Connection(Compose.this);  //is supposed to connect you to the established server
//                  serverConnect.run();  //runs the connection
//
//              }
//                      });
//        connectThread.start();

    }

    public void getMessages() {
        Thread retrieve = null;

        class get implements Runnable {
            @Override
            public void run() {
                ArrayList<String> messages = new ArrayList<String>();

                String ip = "10.0.2.2";
                int portNumber = 8889;
                try {
                    Socket clientSocket = new Socket(ip,portNumber);
                    System.out.println("Creating new Socket");

                    DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());
                    DataInputStream dataIn = new DataInputStream(clientSocket.getInputStream());

                    dataOut.writeBytes("Message Request"); //Temp Out message
                    String msgData = dataIn.readUTF(); //Read in all messages
                    System.out.println(msgData);
                    String[] tempMessages = msgData.split(":");

                    messages.clear();

                    for (int i = 0; i < tempMessages.length; i++) {
                        messages.add(tempMessages[i]);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        retrieve = new Thread(new get());
        retrieve.start();
    }

    //adds the string to the input message and notifies the array adapter for list of change.
    public void displayMessage(String string){
        input_messages.add(string);
        testMessages[2] = string;
        adapter.notifyDataSetChanged();
    }
    

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send:
                System.out.println("start send");
                //puts message from textbox into top or bottom of list veiw
                EditText message = (EditText) findViewById(R.id.type);
                String packet = message.getText().toString();
                displayMessage(packet);

                //sends message encased in text box.
                sendMessage();

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

                String ip = "10.0.2.2";
                int portNumber = 8889;
                try {
                    Socket clientSocket = new Socket(ip,portNumber);
                    System.out.println("Creating new Socket");
                    DataOutputStream send = new DataOutputStream(clientSocket.getOutputStream());
                    packet = "Send Message:" + "TestFromID" + ":" +"TestToID" + ":" + packet;
                    System.out.println("Sending: " + packet);
                    send.writeBytes(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Thread send = null;
        send = new Thread(new sendThread());
        send.start();

        message.setText("");

        type1.setText("");
    }



}





