package com.example.ejmoore.testing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener {
    private ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //User.setupUser();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* bellow applies on click listeners to individual buttons.
        the class has "implements view.onclicklistener" to accomodate
        multiple buttons.
         */

        Button compose = (Button) findViewById(R.id.compose);
        compose.setOnClickListener(this);

        Button busy = (Button) findViewById(R.id.busy);
        busy.setOnClickListener(this);

        Button settings = (Button) findViewById(R.id.Settings);
        settings.setOnClickListener(this);

        ListView People = (ListView) findViewById(R.id.convos);
        //People.setAdapter(new listAdapter(this, R.layout.list_layout, data));
    }


    @Override
    public void onClick(View v) {
        //cases are used to identify the seperate jobs of each button

        switch (v.getId()) { //allows the switching of jobs based on id of button

            case R.id.compose:
                startActivity(new Intent(MainActivity.this, Compose.class));
                break;

            case R.id.busy:
                //block incoming messages.
                break;

            case R.id.Settings: //takes you to settings window
                startActivity(new Intent(MainActivity.this, Settings.class));
                break;
        }


    }

//    private class listAdapter extends ArrayAdapter<String> {
//
//        private int layout;
//        private listAdapter(Context context, int resource, List<String> objects){
//            super(context, resource, objects);
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent){
//
//            ViewFolder mainViewFolder = null;
//            if(convertView==null){
//                LayoutInflater inflater = LayoutInflater.from(getContext());
//                convertView = inflater.inflate(layout, parent, false);
//                ViewFolder viewfolder = new ViewFolder();
//                viewfolder.thumbnail = (ImageView) convertView.findViewById(R.id.item_thumbnail);
//                viewfolder.title = (TextView) convertView.findViewById(R.id.itemtext);
//                viewfolder.butt = (Button) convertView.findViewById(R.id.talk);
//
//                viewfolder.butt.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        startActivity(new Intent(MainActivity.this, messageList.class));
//                    }
//                });
//
//            }
//            else{
//                mainViewFolder = (ViewFolder) convertView.getTag();
//                mainViewFolder.title.setText(getItem(position));
//
//            }
//            return super.getView(position, convertView, parent);
//        }
//    }
//
//
//    public class ViewFolder{
//        ImageView thumbnail;
//        TextView title;
//        Button butt;
//
//    }

}
