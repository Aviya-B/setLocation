package com.aviya.setlocation;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener
{
 private Button btnAdd;
    private ArrayList<Place> arrayList;
    private ArrayAdapter<Place> adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        btnAdd =  findViewById(R.id.btnAddID);
        btnAdd.setOnClickListener(this);



        Settings setting1=new Settings(20,false,"1234");
        Settings setting2=new Settings(20,false,"1234");
        Settings setting3=new Settings(20,false,"1234");
        Settings setting4=new Settings(20,false,"1234");
        arrayList = new ArrayList<>();
        arrayList.add(new Place("location1",20,30,setting1));
        arrayList.add(new Place("location2",20,30,setting2));
        arrayList.add(new Place("location3",20,30,setting3));
        arrayList.add(new Place("location4",20,30,setting4));

        adapter = new PlaceAdapter(this, arrayList);

        listView = (ListView) findViewById(R.id.myListViewID);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l)
            {
                Intent t = new Intent(MainActivity.this,DisplaySetting.class);
                t.putExtra("index",index);

                startActivity(t);
                //Toast.makeText(MainActivity.this, arrayList.get(index),Toast.LENGTH_LONG).show();
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

            Intent t = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(t);
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        // if service is on
        menu.clear();
        menu.add(0,1,Menu.NONE,"Sign out");
        // if service is off
        menu.clear();
        menu.add(0,2,Menu.NONE,"Sign in");
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case 1:
                Toast.makeText(this, "Sign out", Toast.LENGTH_SHORT).show();
                finish();
            case 2:
                Toast.makeText(this, "Sign in", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}


