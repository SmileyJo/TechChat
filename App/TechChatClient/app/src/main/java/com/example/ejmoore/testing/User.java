package com.example.ejmoore.testing;

import android.widget.EditText;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by ejmoore on 3/17/17.
 */

public class User {
    String id;
    String ip = "10.2.2.2";
    ArrayList<String> messages;
    Socket clientSocket;
    int portNumber = 8889;

    public void User(String uId) {

        messages = new ArrayList<String>();
        try {
            clientSocket = new Socket(ip,portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkSocket() {
        if (clientSocket.isConnected()) {
            return true;
        }
        else {
            try {
                clientSocket = new Socket(ip,portNumber);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (clientSocket.isConnected())
            return true;
        else
            return false;
    }

    public void updateMessages() {

        try {
            if (!checkSocket()) {
                System.out.println("Failure Openning Socket");
                return;
            }

            DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream dataIn = new DataInputStream(clientSocket.getInputStream());

            dataOut.writeBytes("Message Request"); //Temp Out message
            String msgData = dataIn.readUTF(); //Read in all messages

            String[] tempMessages = msgData.split(":");

            messages.clear();

            for (int i = 0; i < tempMessages.length; i++) {
                messages.add(tempMessages[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void sendMessage(String message) {
        try {
            if (!checkSocket()) {
                System.out.println("Failure Openning Socket");
                return;
            }
            System.out.println("Creating new Socket");
            DataOutputStream send = new DataOutputStream(clientSocket.getOutputStream());
            String packet = "Send Message:" + "TestFromID" + ":" +"TestToID" + ":" + message;
            System.out.println("Sending: " + packet);
            send.writeBytes(packet);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
