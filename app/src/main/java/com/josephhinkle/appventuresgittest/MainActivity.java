package com.josephhinkle.appventuresgittest;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int green;
    private int blue;

    Button mbtn_Add;
    EditText meTxt_ArrayWords;
    Spinner mspin_Array;
    ArrayList<String> mlist = new ArrayList<String>();
    ArrayAdapter<String> madapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Toast.makeText(MainActivity.this, "Hey abhinay and pavani", Toast.LENGTH_SHORT).show();
            }
        });

        green = 50;
        blue = 50;

        
        //Trying to add items to spinner array
        madapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mlist);

        View.OnClickListener mlistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meTxt_ArrayWords = (EditText) findViewById(R.id.eTxt_ArrayWords);
                mlist.add(meTxt_ArrayWords.getText().toString());
                meTxt_ArrayWords.setText("");
                madapter.notifyDataSetChanged();
            }
        };

        mbtn_Add = (Button) findViewById(R.id.btn_Add);
        mbtn_Add.setOnClickListener(mlistener);

        mspin_Array = (Spinner) findViewById(R.id.spin_Array);
        mspin_Array.setAdapter(madapter);
        madapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void DavidFixedButtonClick(View view) {
        Intent myIntent = new Intent(MainActivity.this, DavidClass.class);
        startActivity(myIntent);
    }
    public void changeColorClicked(View view) {
        green += 50;
        blue += 20;
        if (green > 255) {
            green = 0;
        }
        if (blue > 255) {
            blue = 0;
        }
        view.setBackgroundColor(Color.rgb(100, green, blue));
    }
}
