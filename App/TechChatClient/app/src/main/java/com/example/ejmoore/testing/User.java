/*name: user class
authors: Eric M
purpose:  This establishes a new user when one is created on the login page
it sets up a profile with associated data like conversations */

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

    public static void setupUser(String user, String password) { //establishes the user to be interpreted by the database
        User.user = user;
        User.password = password;
    }

    public static void initiateConvo(String user) { //establishes that the user can partake in conversations
        User.convoUser = user;
    }
}
