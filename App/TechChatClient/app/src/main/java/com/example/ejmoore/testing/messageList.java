package com.example.ejmoore.testing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 3/13/2017.
 * this page includes a list veiw where messages will be input in order. (topdown or bottom up)
 * includes a multi-line text box to input text.
 * includes a send button.
 * only send button is written bellow
 */


public class messageList extends Activity implements View.OnClickListener{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_list);

        Button send = (Button)  findViewById(R.id.send_message);
        send.setOnClickListener(this);

    }

    public void onClick(View v) {
        {
            switch(v.getId()) {

                case R.id.send_message:
                    //sends message encased in text box.
                    //puts message from textbox into top or bottom of list veiw
                    break;
            }

            //any incoming messages are automatically put into list view in order of received
            //alongside messages input from "send" button

        }
    }

}