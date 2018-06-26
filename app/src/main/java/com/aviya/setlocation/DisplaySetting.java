package com.aviya.setlocation;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplaySetting extends Activity {
    int from_Where_I_Am_Coming = 0;
    private DBHelper mydb ;

    TextView nam ;
    TextView radiu;
    TextView isSilen;
    TextView sms;

    int id_To_Update = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_setting);
//        name = (TextView) findViewById(R.id.editTextName);
//        radius = (TextView) findViewById(R.id.editTextPhone);
//        isSilent = (TextView) findViewById(R.id.editTextStreet);
//        sms = (TextView) findViewById(R.id.editTextEmail);
        nam = (TextView) findViewById(R.id.textView1);
        radiu = (TextView) findViewById(R.id.textView2);
        isSilen = (TextView) findViewById(R.id.textView3);
        sms = (TextView) findViewById(R.id.textView4);

        mydb = new DBHelper(this);

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            int Value = extras.getInt("id");

            if(Value>0) {
                //means this is the view part not the add contact part.
                Cursor rs = mydb.getData(Value);
                id_To_Update = Value;
                rs.moveToFirst();

                String locationName = rs.getString(rs.getColumnIndex(DBHelper.SETTINGS_COLUMN_LOCATION_NAME));
                String radius = rs.getString(rs.getColumnIndex(DBHelper.SETTINGS_COLUMN_RADIUS));
                String isSilent = rs.getString(rs.getColumnIndex(DBHelper.SETTINGS_COLUMN_IS_SILENT));
                String numForSMS = rs.getString(rs.getColumnIndex(DBHelper.SETTINGS_COLUMN_SMS));

                if (!rs.isClosed()) {
                    rs.close();
                }
                Button b = (Button) findViewById(R.id.button1);
                b.setVisibility(View.INVISIBLE);
            }}}}