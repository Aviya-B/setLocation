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

            if(Value>0){
                //means this is the view part not the add contact part.
                Cursor rs = mydb.getData(Value);
                id_To_Update = Value;
                rs.moveToFirst();

                String locationName = rs.getString(rs.getColumnIndex(DBHelper.SETTINGS_COLUMN_LOCATION_NAME));
                String radius = rs.getString(rs.getColumnIndex(DBHelper.SETTINGS_COLUMN_RADIUS));
                String isSilent = rs.getString(rs.getColumnIndex(DBHelper.SETTINGS_COLUMN_IS_SILENT));
                String numForSMS = rs.getString(rs.getColumnIndex(DBHelper.SETTINGS_COLUMN_SMS));

                if (!rs.isClosed())  {
                    rs.close();
                }
                Button b = (Button)findViewById(R.id.button1);
                b.setVisibility(View.INVISIBLE);

                nam.setText((CharSequence)locationName);
                nam.setFocusable(false);
                nam.setClickable(false);

                radiu.setText((CharSequence)radius);
                radiu.setFocusable(false);
                radiu.setClickable(false);

                isSilen.setText((CharSequence)isSilent);
                isSilen.setFocusable(false);
                isSilen.setClickable(false);

                sms.setText((CharSequence)numForSMS);
                sms.setFocusable(false);
                sms.setClickable(false);


            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        Bundle extras = getIntent().getExtras();

        if(extras !=null) {
            int Value = extras.getInt("id");
            if(Value>0){
                getMenuInflater().inflate(R.menu.display_contact, menu);
            } else{
                getMenuInflater().inflate(R.menu.menu_main,menu);
            }
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()) {
            case R.id.Edit_Contact:
                Button b = (Button)findViewById(R.id.button1);
                b.setVisibility(View.VISIBLE);
                nam.setEnabled(true);
                nam.setFocusableInTouchMode(true);
                nam.setClickable(true);

                radiu.setEnabled(true);
                radiu.setFocusableInTouchMode(true);
                radiu.setClickable(true);

                isSilen.setEnabled(true);
                isSilen.setFocusableInTouchMode(true);
                isSilen.setClickable(true);

                sms.setEnabled(true);
                sms.setFocusableInTouchMode(true);
                sms.setClickable(true);

                return true;
            case R.id.Delete_Contact:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.deleteContact)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                mydb.deleteContact(id_To_Update);
                                Toast.makeText(getApplicationContext(), "Deleted Successfully",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });

                AlertDialog d = builder.create();
                d.setTitle("Are you sure");
                d.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void run(View view) {
        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            int Value = extras.getInt("id");
            if(Value>0){
                if(mydb.updateContact( id_To_Update,nam.getText().toString(),
                        Integer.parseInt(radiu.getText().toString()), Boolean.parseBoolean(isSilen.getText().toString()),
                        Integer.parseInt(sms.getText().toString()))){
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(getApplicationContext(), "not Updated", Toast.LENGTH_SHORT).show();
                }
            } else{
                if(mydb.insertContact(nam.getText().toString(),
                        Integer.parseInt(radiu.getText().toString()), Boolean.parseBoolean(isSilen.getText().toString()),
                        Integer.parseInt(sms.getText().toString()))){
                    Toast.makeText(getApplicationContext(), "done",
                            Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(), "not done",
                            Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        }
    }
}