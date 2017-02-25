package com.example.ejmoore.testing;

import android.app.Activity;
import android.os.Bundle;

import com.example.ejmoore.testing.R;

/**
 * Created by user on 2/22/2017.
 */
public class phoneBook extends Activity {

    //phonebook has a listveiw of any number of clickable items.
    //we want to connect the list veiw of this phoneboook
    //to our saved "friends/contacts" in the database.

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.existingcontact);
    }
}