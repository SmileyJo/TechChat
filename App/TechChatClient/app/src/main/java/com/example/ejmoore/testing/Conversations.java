package com.example.ejmoore.testing;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Conversations extends Activity {

    ArrayList<String> conversations = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    String[] arr = {"","","","",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversations);

        conversations.add("Testing");

        ListView list = (ListView) findViewById(R.id.list_view);

        int i = 0;
        for(String s : conversations) {
            arr[i++] = s;
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                System.out.println("Item contents: " + item);
                User.initiateConvo(item);
                startActivity(new Intent(Conversations.this, Compose.class));
            }
        });

        getConvos();
    }


    public void getConvos() {
        System.out.println("Getting Convos");


        Thread thread = null;

        class convoRequest implements Runnable {
            @Override
            public void run() {

                String ip = "10.0.2.2";
                int portNumber = 8888;
                try {
                    Socket clientSocket = new Socket(ip,portNumber);
                    System.out.println("Creating new Socket");

                    DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());
                    DataInputStream dataIn  = new DataInputStream(clientSocket.getInputStream());

                    dataOut.writeBytes("Login:" + User.user + ":" + User.password);
                    String response = "";

                    byte[] temp = new byte[1];
                    for (int i = 0; i < 3; i++) {
                        dataIn.read(temp);
                        response += (char) temp[0];
                    }

                    System.out.println("Response:" + response);

                    if (response.equals("ack")) {
                        System.out.println("Successfully Logged In");
                    } else {
                        System.out.println("Failed to Log In");
                        return;
                    }

                    System.out.println("Sending:" + "Conversation Request:" + User.user);

                    dataOut.writeBytes("Conversation Request:" + User.user);

                    conversations.clear();

                    String otherUser = "";
                    while (dataIn.read(temp) != -1) {
                        char c = (char) temp[0];
                        System.out.println("Readingin character: " + c);
                        if (c == '\n' || c == ':') {
                            System.out.println(otherUser);
                            if (!otherUser.equals("")) conversations.add(otherUser);
                            otherUser = "";
                            continue;
                        } else {
                            otherUser = otherUser + c;
                        }
                    }
                    System.out.println(otherUser);
                    conversations.add(otherUser);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        thread = new Thread(new convoRequest());
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int i = 0;
        for (String s : conversations) {
            arr[i++] = s;
        }

        adapter.notifyDataSetChanged();
    }
}
