package mtu.techchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ComposePage extends AppCompatActivity {
//this is the secondary page that allows us to compose a message

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_page);
    }
}
