package com.example.ejmoore.testing;

import android.app.Activity;
import android.icu.util.VersionInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;

/**
 * Created by JO-T on 2/27/2017.
 */
public class Settings extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);


        /*
        bellow is the listener for the text input of our auto-response
        it converts the input to a string that can be used throughout the
        rest of the code.
        you can reerance this string by calling
         */

    }



    public void onCheckBoxClicked(View v1){
        boolean checked = ((CheckBox) v1).isChecked();


        switch(v1.getId()){

            case R.id.delete1:
                if(checked){
                    //delete2 and delete3 cannot be checked at the same time
                    //if either are checked, uncheck them. (swap check)
                    //message input deletes from database after 50 messages.
                    //deletes FIFO from queue
                }
                else{
                    //if delete 2 or delete3 are unchecked, auto-check delete1
                    //else do nothing
                }
                break;
            case R.id.delete2:
                if(checked){
                    //delete1 and delete3 cannot be checked at the same time
                    //if either are checked, uncheck them. (swap check)
                    //message input deletes from database after 100 messages.
                    //deletes FIFO from queue
                }
                else{
                    //do nothing
                }
                break;

            case R.id.delete3:
                if(checked){
                    //delete1 and delete2 cannot be checked at the same time
                    //if either are checked, uncheck them. (swap check)
                    //message input deletes from database after 200 messages.
                    //deletes FIFO from queue
                }
                else{
                    //do nothing
                }
                break;

            case R.id.OFFVibrate:
                if(checked){
                    //when message=received && block=on, do not vibrate
                }
                else{
                    //do nothing
                }
                break;

            case R.id.showmessage:
                if(checked){
                    //when message=received && block=on
                    //turn off any visual indicators that a message is received
                }
                else {//do nothing
                }
                break;

            case R.id.autoresponse:
                if(checked){

                    //send auto-response to anyone who sends a message while block=on


                    // read text input from autoresponseTEXT field
                    EditText auto = (EditText)findViewById(R.id.autoresponseTEXT);
                    String autoTEXT = auto.getText().toString();
                    //above code should allow you to use the string "autoTEXT" in other areas.

                    if(autoTEXT.length()== 0) { //this helps validate that text input is being received.
                        auto.setError("Please enter an Auto-Response");
                    }
                }
                else{
                    //shut off autoresponseTEXT field so nothing can be entered into it.
                }
        }
    }


}