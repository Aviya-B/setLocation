package com.aviya.setlocation;

import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class LocationActivity extends AppCompatActivity  implements View.OnClickListener {

    private Button btnAdd;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        btnAdd =  findViewById(R.id.btnAddID);
        btnAdd.setOnClickListener(this);
        arrayList = new ArrayList<>();
        arrayList.add("apple");
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView = (ListView) findViewById(R.id.myListViewID);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l)
            {
                Intent t = new Intent(LocationActivity.this,SettingActivity.class);
                startActivity(t);
                Toast.makeText(LocationActivity.this, arrayList.get(index),Toast.LENGTH_LONG).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int index, long l)
            {

                arrayList.remove(index);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v==btnAdd) {

            Intent t = new Intent(this, MapsActivity.class);
            startActivity(t);
        }
    }
}
