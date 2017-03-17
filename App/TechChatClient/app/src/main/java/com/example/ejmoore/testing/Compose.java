package com.example.ejmoore.testing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Compose extends Activity implements View.OnClickListener {

    ArrayList<String> input_messages = new ArrayList<String>();


//    protected void addMessage(String in){
//        //input from send bar is added to array
//            input_messages.add(in);
//
//        //incoming input from contact is added to array
//
//        //delete message based on settings
//
//        //pull from client
//
//    }

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

        input_messages.add("bbbbbbb");
        input_messages.add("aaaaaaaa");
        input_messages.add("ccccccccc");

        ListView messagelist = (ListView) findViewById(R.id.messages);

//        for(int i=0; i< input_messages.size(); i++){
//            messagelist.(input_messages.get(i));
//        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send:
                //sends message encased in text box.
                //puts message from textbox into top or bottom of list veiw
                // read text input from message field

                sendMessage();
//                EditText YOU = (EditText)findViewById(R.id.Message);
//                String yourmessage = YOU.getText().toString();
//                addMessage(yourmessage); //add message to arraylist

                break;

            case R.id.phonebook: //got to phonebook list. for some reason this still does not work.
                startActivity(new Intent(Compose.this, phoneBook.class));
                break;
        }

        //any incoming messages are automatically put into list view in order of received
        //alongside messages input from "send" button
    }

    public void sendMessage() {
        int portNumber = 8889;
        try {
            System.out.println("Creating new Socket");
            Socket clientSocket = new Socket("10.0.2.2", portNumber);
            DataOutputStream send = new DataOutputStream(clientSocket.getOutputStream());

            EditText message = (EditText) findViewById(R.id.Message);
            String packet = message.getText().toString();
            packet = "Send message:" + "TestFromID" + ":" + packet;

            System.out.println("Sending: " + packet);
            send.writeBytes(packet);

            message.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class listAdapter extends ArrayAdapter<String> {

        private int layout;

        private listAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
        }
    }
}

//        @Override
//        public View getView(int position, View convertView, ViewGroup parent){
//
//            ViewFolder mainViewFolder = null;
//            if(convertView==null){
//                LayoutInflater inflater = LayoutInflater.from(getContext());
//                convertView = inflater.inflate(layout, parent, false);
//                ViewFolder viewfolder = new ViewFolder();
//                viewfolder.usermessage = (TextView) convertView.findViewById(R.id.Message);
//            }
//            else{
//                mainViewFolder = (ViewFolder) convertView.getTag();
//                mainViewFolder.usermessage.setText(getItem(position));
//
//            }
//            return super.getView(position, convertView, parent);
//        }
//    }


//    public class ViewFolder{
//        TextView usermessage;
//    }



