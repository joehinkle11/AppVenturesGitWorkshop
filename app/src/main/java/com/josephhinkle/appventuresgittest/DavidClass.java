package com.josephhinkle.appventuresgittest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by davidjohn on 2/19/16.
 */
public class DavidClass extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.david_activity);


    }

    public void pressMeClick(View view) {
        Intent myIntent = new Intent(DavidClass.this, MainActivity.class);
        startActivity(myIntent);
    }


}
