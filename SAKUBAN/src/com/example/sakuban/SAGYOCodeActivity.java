package com.example.sakuban;

import db.DbAdapter;
import db.SAGYO_CODE_DEF;
import db.SAGYO_NO_DEF;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.support.v4.app.NavUtils;

public class SAGYOCodeActivity extends Activity {

	static DbAdapter dbAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sagyocode);
        dbAdapter = new DbAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_sagyocode, menu);
        return true;
    }

    public void registSAGYOCODE(View v){

    	Uri uri =Uri.parse("content://db/SAGYO_CODE_DEF");

        ContentValues values = new ContentValues();
        EditText cdNo = (EditText)findViewById(R.id.SAGYOCode_NO);
        EditText cdName = (EditText)findViewById(R.id.SAGYOCode_NAME);
    	values.put(SAGYO_CODE_DEF.getROOT_ID(),"00");
    	values.put(SAGYO_CODE_DEF.getSAGYO_CODE_NAME(),cdName.getText().toString());
    	values.put(SAGYO_CODE_DEF.getSAGYO_CODE(),cdNo.getText().toString());
		Log.d(this.toString(),"uri is " + uri);

    	dbAdapter.insert(uri, values);
    }

    public void moveToBACK(View v){
    	Intent i = new Intent(SAGYOCodeActivity.this,SelectActivity.class);
    	startActivity(i);
    }



}
