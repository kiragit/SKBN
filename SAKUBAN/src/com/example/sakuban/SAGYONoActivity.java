package com.example.sakuban;

import db.DbAdapter;
import db.OUTPUT_FORM_DEF;
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

public class SAGYONoActivity extends Activity {

	static DbAdapter dbAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sagyono);
        dbAdapter = new DbAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_sagyono, menu);
        return true;
    }

    public void registSAGYONO(View v){

    	Uri uri =Uri.parse("content://db/SAGYO_NO_DEF");

        ContentValues values = new ContentValues();
        EditText pjNo = (EditText)findViewById(R.id.SAGYONo_PJNO);
        EditText pjName = (EditText)findViewById(R.id.SAGYONo_PJNAME);
    	values.put(SAGYO_NO_DEF.getROOT_ID(),"00");
    	values.put(SAGYO_NO_DEF.getSAGYO_NO(),pjNo.getText().toString());
    	values.put(SAGYO_NO_DEF.getSAGYO_NO_NAME(),pjName.getText().toString());
		Log.d(this.toString(),"uri is " + uri);

    	dbAdapter.insert(uri, values);
    }

    public void moveToBACK(View v){
    	Intent i = new Intent(SAGYONoActivity.this,SelectActivity.class);
    	startActivity(i);
    }


}
