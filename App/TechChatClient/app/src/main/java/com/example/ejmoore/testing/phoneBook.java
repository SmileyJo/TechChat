/*name: Compose Page
authors: James G, Jo T.
purpose:  This page allows the user to veiw their list of contacts or "Friends"
this page does not currently function,norisit actively used
*/

package com.example.ejmoore.testing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        
    }
}
