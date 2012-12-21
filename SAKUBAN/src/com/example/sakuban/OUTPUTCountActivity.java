package com.example.sakuban;

import db.DbAdapter;
import db.OUTPUT_COUNT_DEF;
import db.WLOG_DEF;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.support.v4.app.NavUtils;

public class OUTPUTCountActivity extends Activity {

	static DbAdapter dbAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_count);
        dbAdapter = new DbAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_output, menu);
        return true;
    }

    public void registCount(View v){

    	Uri uri =Uri.parse("content://db/OUTPUT_COUNT_DEF");

        ContentValues values = new ContentValues();
        EditText t = (EditText)findViewById(R.id.CountTxt);
    	values.put(OUTPUT_COUNT_DEF.getCOUNT(),t.getText().toString());
		Log.d(this.toString(),"uri is " + uri);

    	dbAdapter.insert(uri, values);
    }

    public void moveToBACK(View v){
    	Intent i = new Intent(OUTPUTCountActivity.this,SelectActivity.class);
    	startActivity(i);
    }
}
