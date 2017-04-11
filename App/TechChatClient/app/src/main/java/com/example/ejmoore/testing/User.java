package com.example.ejmoore.testing;

import android.os.AsyncTask;
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

public class User{
    static String user;
    static String password;

    static String convoUser;

    public static void setupUser(String user, String password) {
        User.user = user;
        User.password = password;
    }

    public static void initiateConvo(String user) {
        User.convoUser = user;
    }
}
