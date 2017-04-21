/*packagename: home page
authors: James G, Eric M, Jo T.
purpose:  This page allows the user to veiwtheir "button" options.As it stands, only the "compose" page functions

*/

package com.example.ejmoore.testing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class HomePage extends Activity implements View.OnClickListener {

    private ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        /* bellow applies on click listeners to individual buttons.
        the class has "implements view.onclicklistener" to accomodate
        multiple buttons.
         */
        
        //the items listed bellow are clickable buttons to take you to varying pages
        Button conversations = (Button) findViewById(R.id.conversations);
        conversations.setOnClickListener(this);

        Button busy = (Button) findViewById(R.id.busy);
        busy.setOnClickListener(this);

        Button settings = (Button) findViewById(R.id.Settings);
        settings.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        //cases are used to identify the seperate jobs of each button

        switch (v.getId()) { //allows the switching of jobs based on id of button

            case R.id.conversations:
                startActivity(new Intent(HomePage.this, Conversations.class));//takes you to list of conversations
                break;

            case R.id.busy:
                //block incoming messages.
                //not yet implimented
                break;

            case R.id.Settings: //takes you to settings window
                //settings window exists and contains objects but does not work functionally
                startActivity(new Intent(HomePage.this, Settings.class));
                break;
        }

    }
    }

