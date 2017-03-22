package com.example.ejmoore.testing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ejmoore.testing.R;

/**
 * Created by user on 2/22/2017.
 */
public class phoneBook extends Activity implements View.OnClickListener{

    //phonebook has a listveiw of any number of clickable items.
    //we want to connect the list veiw of this phoneboook
    //to our saved "friends/contacts" in the database.

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.existingcontact);

        Button messages = (Button) findViewById(R.id.message_list);
        messages.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        {
            switch(v.getId()) {

                case R.id.compose:
                    startActivity(new Intent(phoneBook.this, Compose.class));
                    break;
            }

            }
    }
}