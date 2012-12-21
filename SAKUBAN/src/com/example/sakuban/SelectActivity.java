package com.example.sakuban;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;

public class SelectActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_select, menu);
        return true;
    }

    public void moveToCOUNT(View v){
    	Intent i = new Intent(SelectActivity.this,OUTPUTCountActivity.class);
    	startActivity(i);
    }

    public void moveToMAIN(View v){
    	Intent i = new Intent(SelectActivity.this,SKBNActivity.class);
    	startActivity(i);
    }

    public void moveToFORM(View v){
    	Intent i = new Intent(SelectActivity.this,OUTPUTFormActivity.class);
    	startActivity(i);
    }
    public void moveToSAGYONO(View v){
    	Intent i = new Intent(SelectActivity.this,SAGYONoActivity.class);
    	startActivity(i);
    }
    public void moveToSAGYOCODE(View v){
    	Intent i = new Intent(SelectActivity.this,SAGYOCodeActivity.class);
    	startActivity(i);
    }
}
