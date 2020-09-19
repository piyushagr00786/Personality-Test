package com.map.personalitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PersonalityMenu extends ListActivity {
    String []activity={"Healer","Mastermind","Counselor","Architect","Champion","Commander","Visionary","Teacher","Protector","Composer","Inspector","Craftsperson","Provider","Performer","Supervisor","Dynamo",};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality_menu);
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,activity);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        try{
            String s="com.map.personalitytest."+activity[position];
            Class c=Class.forName(s);
            Intent intent=new Intent(this,c);
            startActivity(intent);
        }catch (Exception e){}
    }
}
