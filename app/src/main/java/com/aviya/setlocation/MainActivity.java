package com.aviya.setlocation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    private Button btnChoose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnChoose =  findViewById(R.id.btnChooseID);


        btnChoose.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if(v==btnChoose) {
            Intent t = new Intent(this,LocationActivity.class);
            startActivity(t);
        }




    }
}
